## Preparación

Crea tu área de trabajo y variables útiles:

```bash
mkdir -p ~/dam/{bin,logs,units}
export DAM=~/dam
echo 'export DAM=~/dam' >> ~/.bashrc
```

Comprobar versión de systemd y que el *user manager* está activo:

```bash
systemctl --user --version | head -n1
systemctl --user status --no-pager | head -n5
```
**Pega salida aquí:**

```text
systemd 255 (255.4-1ubuntu8.6)
● a108pc14
    State: running
    Units: 261 loaded (incl. loaded aliases)
     Jobs: 0 queued
   Failed: 0 units

```

**Reflexiona la salida:**

```text
Mi version del sistema operativo 255.4-1ubuntu8.6, actualmente se esta ejecutando y no tiene ningun trabajo ni ningun fallo registrado
```

---

## Bloque 1 — Conceptos (breve + fuentes)

1) ¿Qué es **systemd** y en qué se diferencia de SysV init?  

**Respuesta:**  

systemd es un gestor del sistema y de servicios operativos Linux actual, mientras que SysV init es de los primeros en linux.

_Fuentes:_

https://documentation.suse.com/es-es/sle-micro/6.0/html/Micro-systemd-basics/index.html

2) **Servicio** vs **proceso** (ejemplos).  

**Respuesta:**  

Un ejemplo de proceso es Firefox y un servicio es un servidor de base de datos como MySQL

_Fuentes:_

https://medium.com/enredando-con-linux/linux-procesos-y-administraci%C3%B3n-de-servicios-9147c27f7f9d

3) ¿Qué son los **cgroups** y para qué sirven?  

**Respuesta:**  

Son una función kernel de linux que permite agrupar procesos y distribuir de forma granular y jerárquica los recursos del sistema

_Fuentes:_

https://elpuig.xeill.net/Members/vcarceler/articulos/introduccion-a-los-grupos-de-control-cgroups-de-linux

4) ¿Qué es un **unit file** y tipos (`service`, `timer`, `socket`, `target`)?  

**Respuesta:**  

Un unit file es el archivo de configuración que le dice a systemd cómo manejar un recurso en el sistema

El tipo service se usa para definir demonios o servicios que se pueden iniciar, detener, reiniciar o recargar

El tipo timer se utiliza para programar la ejecución de unidades en momentos específicos o de forma periódica, similar a cron.

Socket: esta unidad encierra un socket del sistema de archivos o de red.

El tipo target sirve como una forma de agrupar lógicamente otras unidades y controlar su conjunto.

_Fuentes:_
https://nebul4ck.wordpress.com/2015/02/11/sobre-systemd-mejoras-en-systemd-units-y-targets-uso-de-systemctl-compatibilidad-con-sysv/

5) ¿Qué hace `journalctl` y cómo ver logs **de usuario**?  

**Respuesta:**  

Permite ver, filtrar y analizar los registros del sistema recopilados por systemd-journald.

para ver los logs del usuario se usa journalctl --user

_Fuentes:_
https://keepcoding.io/blog/que-es-journalctl-y-como-usarlo/

---

## Bloque 2 — Práctica guiada (todo en tu `$DAM`)

> Si un comando pide permisos que no tienes, usa la **versión `--user`** o consulta el **ayuda** con `--help` para alternativas.

### 2.1 — PIDs básicos

**11.** PID de tu shell y su PPID.

```bash
echo "PID=$$  PPID=$PPID"
```
**Salida:**

```text
PID=32582  PPID=32572
```

**Pregunta:** ¿Qué proceso es el padre (PPID) de tu shell ahora?  

**Respuesta:**
   PID TTY      STAT   TIME COMMAND
  32572 ?        Ssl    0:00 /usr/libexec/gnome-terminal-server

---

**12.** PID del `systemd --user` (manager de usuario) y explicación.

```bash
pidof systemd --user || pgrep -u "$USER" -x systemd
```

**Salida:**

```text
3316
```
**Pregunta:** ¿Qué hace el *user manager* de systemd para tu sesión?  

**Respuesta:**

Inicia y gestiona servicios y procesos a nivel de usuario

---

### 2.2 — Servicios **de usuario** con systemd

Vamos a crear un servicio sencillo y un timer **en tu carpeta** `~/.config/systemd/user` o en `$DAM/units` (usaremos la primera para que `systemctl --user` lo encuentre).

**13.** Prepara directorios y script de práctica.

```bash
mkdir -p ~/.config/systemd/user "$DAM"/{bin,logs}
cat << 'EOF' > "$DAM/bin/fecha_log.sh"
#!/usr/bin/env bash
mkdir -p "$HOME/dam/logs"
echo "$(date --iso-8601=seconds) :: hello from user timer" >> "$HOME/dam/logs/fecha.log"
EOF
chmod +x "$DAM/bin/fecha_log.sh"
```

**14.** Crea el servicio **de usuario** `fecha-log.service` (**Type=simple**, ejecuta tu script).

```bash
cat << 'EOF' > ~/.config/systemd/user/fecha-log.service
[Unit]
Description=Escribe fecha en $HOME/dam/logs/fecha.log

[Service]
Type=simple
ExecStart=%h/dam/bin/fecha_log.sh
EOF

systemctl --user daemon-reload
systemctl --user start fecha-log.service
systemctl --user status fecha-log.service --no-pager -l | sed -n '1,10p'
```
**Salida (pega un extracto):**

```text
fecha-log.service - Escribe fecha en $HOME/dam/logs/fecha.log
     Loaded: loaded (/home/dam/.config/systemd/user/fecha-log.service; static)
     Active: inactive (dead)

sep 23 18:44:19 a108pc14 systemd[3316]: Started fecha-log.service - Escribe fecha en $HOME/dam/logs/fecha.log.

```
**Pregunta:** ¿Se creó/actualizó `~/dam/logs/fecha.log`? Muestra las últimas líneas:

```bash
tail -n 5 "$DAM/logs/fecha.log"
```

**Salida:**

```text
2025-09-23T18:40:06+01:00 :: hello from user timer
2025-09-23T18:41:26+01:00 :: hello from user timer
2025-09-23T18:44:19+01:00 :: hello from user timer

```

**Reflexiona la salida:**

```text

```

---

**15.** Diferencia **enable** vs **start** (modo usuario). Habilita el **timer**.

```bash
cat << 'EOF' > ~/.config/systemd/user/fecha-log.timer
[Unit]
Description=Timer (usuario): ejecuta fecha-log.service cada minuto

[Timer]
OnCalendar=*:0/1
Unit=fecha-log.service
Persistent=true

[Install]
WantedBy=timers.target
EOF

systemctl --user daemon-reload
systemctl --user enable --now fecha-log.timer
systemctl --user list-timers --all | grep fecha-log || true
```

**Salida (recorta):**

```text
Created symlink /home/dam/.config/systemd/user/timers.target.wants/fecha-log.timer → /home/dam/.config/systemd/user/fecha-log.timer.
Tue 2025-09-23 18:50:00 WEST  10s -                                       - fecha-log.timer                fecha-log.service

```
**Pregunta:** ¿Qué diferencia hay entre `enable` y `start` cuando usas `systemctl --user`?  

**Respuesta:**
enable configura un servicio para iniciarse automáticamente al arrancar el sistema, mientras que start inicia el servicio inmediatamente

---

**16.** Logs recientes **del servicio de usuario** con `journalctl --user`.

```bash
journalctl --user -u fecha-log.service -n 10 --no-pager
```

**Salida:**

```text
sep 23 18:44:19 a108pc14 systemd[3316]: Started fecha-log.service - Escribe fecha en $HOME/dam/logs/fecha.log.
sep 23 18:50:52 a108pc14 systemd[3316]: Started fecha-log.service - Escribe fecha en $HOME/dam/logs/fecha.log.
sep 23 18:51:52 a108pc14 systemd[3316]: Started fecha-log.service - Escribe fecha en $HOME/dam/logs/fecha.log.

```
**Pregunta:** ¿Ves ejecuciones activadas por el timer? ¿Cuándo fue la última?  

**Respuesta:**

Si, la última fue a las 18:51:52
---

### 2.3 — Observación de procesos sin root

**17.** Puertos en escucha (lo que puedas ver como usuario).

```bash
lsof -i -P -n | grep LISTEN || ss -lntp
```
**Salida:**

```text
State   Recv-Q   Send-Q     Local Address:Port      Peer Address:Port  Process  
LISTEN  0        64               0.0.0.0:2049           0.0.0.0:*              
LISTEN  0        4096       127.0.0.53%lo:53             0.0.0.0:*              
LISTEN  0        4096             0.0.0.0:52579          0.0.0.0:*              
LISTEN  0        4096             0.0.0.0:35939          0.0.0.0:*              
LISTEN  0        4096             0.0.0.0:111            0.0.0.0:*              
LISTEN  0        4096             0.0.0.0:50329          0.0.0.0:*              
LISTEN  0        32         192.168.122.1:53             0.0.0.0:*              
LISTEN  0        4096             0.0.0.0:8000           0.0.0.0:*              
LISTEN  0        4096          127.0.0.54:53             0.0.0.0:*              
LISTEN  0        64               0.0.0.0:37629          0.0.0.0:*              
LISTEN  0        4096           127.0.0.1:631            0.0.0.0:*              
LISTEN  0        4096             0.0.0.0:58823          0.0.0.0:*              
LISTEN  0        4096               [::1]:631               [::]:*              
LISTEN  0        64                  [::]:2049              [::]:*              
LISTEN  0        4096                   *:22                   *:*              
LISTEN  0        511                    *:80                   *:*              
LISTEN  0        4096                [::]:111               [::]:*              
LISTEN  0        4096                [::]:33303             [::]:*              
LISTEN  0        4096                [::]:50305             [::]:*              
LISTEN  0        4096                [::]:8000              [::]:*              
LISTEN  0        4096                [::]:43665             [::]:*              
LISTEN  0        4096                   *:9100                 *:*              
LISTEN  0        64                  [::]:42213             [::]:*              
LISTEN  0        4096                [::]:42961             [::]:*     
```
**Pregunta:** ¿Qué procesos *tuyos* están escuchando? (si no hay, explica por qué)  

**Respuesta:**

---

**18.** Ejecuta un proceso bajo **cgroup de usuario** con límite de memoria.

```bash
systemd-run --user --scope -p MemoryMax=50M sleep 200
ps -eo pid,ppid,cmd,stat | grep "[s]leep 200"
```

**Salida:**

```text
Running as unit: run-rf9d35c8ae62e42feaaeb9fc2b742b0b6.scope; invocation ID: de56c032c7064088a707ca17116ca641

```
**Pregunta:** ¿Qué ventaja tiene lanzar con `systemd-run --user` respecto a ejecutarlo “a pelo”?  

**Respuesta:**
 
Proporciona una capa adicional de control y gestión que no está disponible al ejecutar comandos directamente

---

**19.** Observa CPU en tiempo real con `top` (si tienes `htop`, también vale).

```bash
top -b -n 1 | head -n 15
```
**Salida (resumen):**

```text
top - 19:13:06 up  4:09,  1 user,  load average: 2,42, 2,14, 1,93
Tareas: 405 total,   1 ejecutar,  404 hibernar,    0 detener,    0 zombie
%Cpu(s):  7,1 us,  1,9 sy,  0,0 ni, 89,6 id,  1,3 wa,  0,0 hi,  0,0 si,  0,0 st 
MiB Mem :  31453,3 total,  22878,2 libre,   6035,6 usado,   3002,4 búf/caché    
MiB Intercambio:   2048,0 total,   2048,0 libre,      0,0 usado.  25417,7 dispon

    PID USUARIO   PR  NI    VIRT    RES    SHR S  %CPU  %MEM     HORA+ ORDEN
  75001 dam       20   0 7264636 887352 106452 S  54,5   2,8   7:48.45 Isolate+
   4094 dam       20   0   11,9g 674972 279336 S  27,3   2,1  67:58.00 firefox+
   2229 root      20   0 1272976 135836  81632 S   9,1   0,4   7:06.99 Xorg
   3746 dam       20   0 5417352 237968 131444 S   9,1   0,7  17:08.20 cinnamon
      1 root      20   0   23240  14344   9520 S   0,0   0,0   0:01.87 systemd
      2 root      20   0       0      0      0 S   0,0   0,0   0:00.02 kthreadd
      3 root      20   0       0      0      0 S   0,0   0,0   0:00.00 pool_wo+
      4 root       0 -20       0      0      0 I   0,0   0,0   0:00.00 kworker+
```
**Pregunta:** ¿Cuál es tu proceso con mayor `%CPU` en ese momento?  

**Respuesta:**
  75001 dam       20   0 7264636 887352 106452 S  54,5   2,8   7:48.45 Isolate+

---

**20.** Traza syscalls de **tu propio proceso** (p. ej., el `sleep` anterior).
> Nota: Sin root, no podrás adjuntarte a procesos de otros usuarios ni a algunos del sistema.

```bash
pid=$(pgrep -u "$USER" -x sleep | head -n1)
strace -p "$pid" -e trace=nanosleep -tt -c -f 2>&1 | sed -n '1,10p'
```

**Salida (fragmento):**

```text
strace: must have PROG [ARGS] or -p PID
Try 'strace -h' for more information.
```
**Pregunta:** Explica brevemente la syscall que observaste.  

**Respuesta:**

---

### 2.4 — Estados y jerarquía (sin root)

**21.** Árbol de procesos con PIDs.

```bash
pstree -p | head -n 50
```

**Salida (recorta):**

```text
systemd(1)-+-ModemManager(1856)-+-{ModemManager}(1866)
           |                    |-{ModemManager}(1869)
           |                    `-{ModemManager}(1871)
           |-NetworkManager(1824)-+-{NetworkManager}(1861)
           |                      |-{NetworkManager}(1862)
           |                      `-{NetworkManager}(1863)
           |-accounts-daemon(1175)-+-{accounts-daemon}(1201)
           |                       |-{accounts-daemon}(1202)
           |                       `-{accounts-daemon}(1826)
           |-agetty(2232)
           |-apache2(2283)-+-apache2(2294)
           |               |-apache2(2295)
           |               |-apache2(2296)
           |               |-apache2(2297)
           |               `-apache2(2299)
           |-at-spi2-registr(3678)-+-{at-spi2-registr}(3680)
           |                       |-{at-spi2-registr}(3681)
           |                       `-{at-spi2-registr}(3682)
           |-avahi-daemon(1177)---avahi-daemon(1265)
           |-blkmapd(1128)
           |-chrome_crashpad(32898)-+-{chrome_crashpad}(32899)
           |                        `-{chrome_crashpad}(32900)
           |-colord(2021)-+-{colord}(2028)
           |              |-{colord}(2029)
           |              `-{colord}(2031)
           |-containerd(2001)-+-{containerd}(2023)
           |                  |-{containerd}(2024)
           |                  |-{containerd}(2025)
           |                  |-{containerd}(2026)
           |                  |-{containerd}(2027)
           |                  |-{containerd}(2042)
           |                  |-{containerd}(2043)
           |                  |-{containerd}(2055)
           |                  |-{containerd}(2056)
           |                  |-{containerd}(2062)
           |                  |-{containerd}(2063)
           |                  |-{containerd}(2064)
           |                  |-{containerd}(2380)
           |                  |-{containerd}(2381)
           |                  |-{containerd}(2382)
           |                  `-{containerd}(2383)
           |-containerd-shim(3138)-+-apache2(3161)-+-apache2(3277)
           |                       |               |-apache2(3278)
           |                       |               |-apache2(3279)
           |                       |               |-apache2(3280)
           |                       |               `-apache2(3281)
           |                       |-{containerd-shim}(3139)
           |                       |-{containerd-shim}(3140)
           |                       |-{containerd-shim}(3141)
           |                       |-{containerd-shim}(3142)

```
**Pregunta:** ¿Bajo qué proceso aparece tu `systemd --user`?  

**Respuesta:**
 aparece como un proceso hijo del demonio principal de systemd con PID 1

---

**22.** Estados y relación PID/PPID.

```bash
ps -eo pid,ppid,stat,cmd | head -n 20
```
**Salida:**

```text
    PID    PPID STAT CMD
      1       0 Ss   /sbin/init splash
      2       0 S    [kthreadd]
      3       2 S    [pool_workqueue_release]
      4       2 I<   [kworker/R-rcu_g]
      5       2 I<   [kworker/R-rcu_p]
      6       2 I<   [kworker/R-slub_]
      7       2 I<   [kworker/R-netns]
     10       2 I<   [kworker/0:0H-events_highpri]
     12       2 I<   [kworker/R-mm_pe]
     13       2 I    [rcu_tasks_kthread]
     14       2 I    [rcu_tasks_rude_kthread]
     15       2 I    [rcu_tasks_trace_kthread]
     16       2 S    [ksoftirqd/0]
     17       2 I    [rcu_preempt]
     18       2 S    [migration/0]
     19       2 S    [idle_inject/0]
     20       2 S    [cpuhp/0]
     21       2 S    [cpuhp/1]
     22       2 S    [idle_inject/1]

```
**Pregunta:** Explica 3 flags de `STAT` que veas (ej.: `R`, `S`, `T`, `Z`, `+`).  

**Respuesta:**

R (Ready): Indica que un dispositivo está listo para recibir y procesar datos.
S (Status): Muestra el estado actual de un dispositivo o conexión.
T (Transmission): Permite que un dispositivo transmita datos a través de la red.


---

**23.** Suspende y reanuda **uno de tus procesos** (no crítico).

```bash
# Crea un proceso propio en segundo plano
sleep 120 &
pid=$!
# Suspende
kill -STOP "$pid"
# Estado
ps -o pid,stat,cmd -p "$pid"
# Reanuda
kill -CONT "$pid"
# Estado
ps -o pid,stat,cmd -p "$pid"
```
**Pega los dos estados (antes/después):**

```text
antes:

  PID STAT CMD
  93656 T    sleep 120

  PID STAT CMD


```
**Pregunta:** ¿Qué flag indicó la suspensión?  

**Respuesta:**

---

**24. (Opcional)** Genera un **zombie** controlado (no requiere root).

```bash
cat << 'EOF' > "$DAM/bin/zombie.c"
#include <stdlib.h>
#include <unistd.h>
int main() {
  if (fork() == 0) { exit(0); } // hijo termina
  sleep(60); // padre no hace wait(), hijo queda zombie hasta que padre termine
  return 0;
}
EOF
gcc "$DAM/bin/zombie.c" -o "$DAM/bin/zombie" && "$DAM/bin/zombie" &
ps -el | grep ' Z '
```
**Salida (recorta):**

```text

```
**Pregunta:** ¿Por qué el estado `Z` y qué lo limpia finalmente?  

**Respuesta:**

---

### 2.5 — Limpieza (solo tu usuario)

Detén y deshabilita tu **timer/servicio de usuario** y borra artefactos si quieres.

```bash
systemctl --user disable --now fecha-log.timer
systemctl --user stop fecha-log.service
rm -f ~/.config/systemd/user/fecha-log.{service,timer}
systemctl --user daemon-reload
rm -rf "$DAM/bin" "$DAM/logs" "$DAM/units"
```

---

## ¿Qué estás prácticando?
- [ ] Pegaste **salidas reales**.  
- [ ] Explicaste **qué significan**.  
- [ ] Usaste **systemd --user** y **journalctl --user**.  
- [ ] Probaste `systemd-run --user` con límites de memoria.  
- [ ] Practicaste señales (`STOP`/`CONT`), `pstree`, `ps` y `strace` **sobre tus procesos**.
