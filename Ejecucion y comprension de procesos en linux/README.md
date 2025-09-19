## Bloque 1: Conceptos básicos (teoría)

1. Define qué es un **proceso** y en qué se diferencia de un **programa**.  
    Un proceso es parte de la ejecución de un programa mientras que un programa es un grupo de operaciones ordenadas para lograr un objetivo. _https://www.profesionalreview.com/2020/06/20/cual-es-la-diferencia-entre-un-programa-y-un-proceso/_

2. Explica qué es el **kernel** y su papel en la gestión de procesos.  
    Es el componente central de un sistema operativo y sirve como intefaz principal entre el hardware y el software. _https://salesystems.es/que-es-un-kernel/_

3. ¿Qué son **PID** y **PPID**? Explica con un ejemplo. 
    PID es un número único que se asigna a cada proceso para identificarlos, por ejemplo al usar el comando "ls" se crea un nuevo proceso PID. Mientras que el PPID es el PID del proceso que creó al proceso actual, por ejemplo, si un proceso con PID 11330 crea un proceso hijo, el PPID del proceso hijo será 11330. _https://es.wikipedia.org/wiki/Controlador_PID_

4. Describe qué es un **cambio de contexto** y por qué es costoso.  
    Un cambio de contexto es cuando la operación en donde la CPU termina un proceso y le da prioridad a otro, y es costoso debido a que requiere tiempo y recuros el echo de guardar el estado de un proceso y tener que cargar otro. _https://es.wikipedia.org/wiki/Cambio_de_contexto_

5. Explica qué es un **PCB (Process Control Block)** y qué información almacena.

    Es una estructura de datos que mantiene el sistema operativo para describir y controlar cada proceso que está en marcha. _https://es.wikipedia.org/wiki/Bloque_de_control_del_proceso_

6. Diferencia entre **proceso padre** y **proceso hijo**.  

    Un proceso padre es el que crea a otro proceso mediante una llamada. Puede tener muchos hijos.
    Un proceso hijo es el creado por el padre; hereda recursos (memoria, archivos abiertos, variables de entorno) del padre, pero tiene su propio PID y ejecución independiente.
    _https://www.geeksforgeeks.org/dsa/difference-between-process-parent-process-and-child-process/_

7. Explica qué ocurre cuando un proceso queda **huérfano** en Linux.  

    Un proceso huérfano es aquel cuyo proceso padre ha terminado o ha sido finalizado antes de que el hijo lo haga, así que el hijo sigue ejecutándose pero ya no tiene al padre original.
    _https://en.wikipedia.org/wiki/Orphan_process_

8. ¿Qué es un proceso **zombie**? Da un ejemplo de cómo puede ocurrir. 

    Es un proceso que ya terminó su ejecución, pero sigue apareciendo en la tabla de procesos porque su padre aún no ha leído su estado de salida.
    _https://es.wikipedia.org/wiki/Proceso_zombie_

9. Diferencia entre **concurrencia** y **paralelismo**.  

    La concurrencia es la capacidad de un sistema para manejar múltiples tareas a la vez, pero no necesariamente ejecutándolas simultáneamente.

    Y el paralelismo es la capacidad de ejecutar varias tareas literalmente al mismo tiempo, utilizando múltiples núcleos o procesadores.

    _https://es.wikipedia.org/wiki/Concurrencia_(inform%C3%A1tica)_
    _https://es.wikipedia.org/wiki/Computaci%C3%B3n_paralela_

10. Explica qué es un **hilo (thread)** y en qué se diferencia de un proceso.  

    Un hilo es un camino de ejecución dentro de ese proceso que comparte recursos con otros hilos del mismo proceso, mientra que un proceso es un programa completo en ejecución con sus propios recursos.
    https://es.wikipedia.org/wiki/Hilo_(informática)
---

## Bloque 2: Práctica con comandos en Linux



11. Usa echo $$ para mostrar el PID del proceso actual.
    ```
    13825
    ```
12. Usa echo $PPID para mostrar el PID del proceso padre.
    ```
    13816
    ```
13. Ejecuta pidof systemd y explica el resultado.
    ```
    3326
    ```
14. Abre un programa gráfico (ejemplo: gedit) y usa pidof para obtener sus PID.
    ```
    
    ```
15. Ejecuta ps -e y explica qué significan sus columnas.
    ```
            PID TTY          TIME CMD
          1 ?        00:00:02 systemd
          2 ?        00:00:00 kthreadd
          3 ?        00:00:00 pool_workqueue_release
          4 ?        00:00:00 kworker/R-rcu_g
          5 ?        00:00:00 kworker/R-rcu_p
          6 ?        00:00:00 kworker/R-slub_
          7 ?        00:00:00 kworker/R-netns
          8 ?        00:00:00 kworker/0:0-events
         10 ?        00:00:00 kworker/0:0H-events_highpri
         12 ?        00:00:00 kworker/R-mm_pe
         13 ?        00:00:00 rcu_tasks_kthread
         14 ?        00:00:00 rcu_tasks_rude_kthread
         15 ?        00:00:00 rcu_tasks_trace_kthread
         16 ?        00:00:00 ksoftirqd/0
         17 ?        00:00:06 rcu_preempt
         18 ?        00:00:00 migration/0
         19 ?        00:00:00 idle_inject/0
         20 ?        00:00:00 cpuhp/0
         21 ?        00:00:00 cpuhp/1
         22 ?        00:00:00 idle_inject/1
         23 ?        00:00:00 migration/1
         24 ?        00:00:00 ksoftirqd/1
         26 ?        00:00:00 kworker/1:0H-events_highpri
         27 ?        00:00:00 cpuhp/2
         28 ?        00:00:00 idle_inject/2
         29 ?        00:00:00 migration/2
         30 ?        00:00:00 ksoftirqd/2
         32 ?        00:00:00 kworker/2:0H-events_highpri
         33 ?        00:00:00 cpuhp/3
         34 ?        00:00:00 idle_inject/3
         35 ?        00:00:00 migration/3
         36 ?        00:00:00 ksoftirqd/3
         38 ?        00:00:00 kworker/3:0H-events_highpri
         39 ?        00:00:00 cpuhp/4
         40 ?        00:00:00 idle_inject/4
         41 ?        00:00:00 migration/4
         42 ?        00:00:00 ksoftirqd/4
         44 ?        00:00:00 kworker/4:0H-events_highpri
         45 ?        00:00:00 cpuhp/5
         46 ?        00:00:00 idle_inject/5
         47 ?        00:00:00 migration/5
         48 ?        00:00:00 ksoftirqd/5
         50 ?        00:00:00 kworker/5:0H-events_highpri
         51 ?        00:00:00 cpuhp/6
         52 ?        00:00:00 idle_inject/6
         53 ?        00:00:00 migration/6
         54 ?        00:00:00 ksoftirqd/6
         56 ?        00:00:00 kworker/6:0H-events_highpri
         57 ?        00:00:00 cpuhp/7
         58 ?        00:00:00 idle_inject/7
         59 ?        00:00:00 migration/7
         60 ?        00:00:00 ksoftirqd/7
         62 ?        00:00:00 kworker/7:0H-events_highpri
         63 ?        00:00:00 cpuhp/8
         64 ?        00:00:00 idle_inject/8
         65 ?        00:00:00 migration/8
         66 ?        00:00:00 ksoftirqd/8
         68 ?        00:00:00 kworker/8:0H-events_highpri
         69 ?        00:00:00 cpuhp/9
         70 ?        00:00:00 idle_inject/9
         71 ?        00:00:00 migration/9
         72 ?        00:00:00 ksoftirqd/9
         74 ?        00:00:00 kworker/9:0H-events_highpri
         75 ?        00:00:00 cpuhp/10
         76 ?        00:00:00 idle_inject/10
         77 ?        00:00:00 migration/10
         78 ?        00:00:00 ksoftirqd/10
         80 ?        00:00:00 kworker/10:0H-events_highpri
         81 ?        00:00:00 cpuhp/11
         82 ?        00:00:00 idle_inject/11
         83 ?        00:00:00 migration/11
         84 ?        00:00:00 ksoftirqd/11
         86 ?        00:00:00 kworker/11:0H-events_highpri
         89 ?        00:00:00 kdevtmpfs
         90 ?        00:00:00 kworker/R-inet_
         92 ?        00:00:00 kauditd
         96 ?        00:00:00 khungtaskd
         98 ?        00:00:00 oom_reaper
         99 ?        00:00:00 kworker/R-write
        100 ?        00:00:00 kcompactd0
        101 ?        00:00:00 ksmd
        102 ?        00:00:00 khugepaged
        103 ?        00:00:00 kworker/R-kinte
        104 ?        00:00:00 kworker/R-kbloc
        105 ?        00:00:00 kworker/R-blkcg
        106 ?        00:00:00 irq/9-acpi
        109 ?        00:00:00 kworker/R-tpm_d
        110 ?        00:00:00 kworker/R-ata_s
        111 ?        00:00:00 kworker/R-md
        112 ?        00:00:00 kworker/R-md_bi
        113 ?        00:00:00 kworker/R-edac-
        115 ?        00:00:00 kworker/R-devfr
        116 ?        00:00:00 watchdogd
        117 ?        00:00:00 kworker/2:1H-kblockd
        118 ?        00:00:00 kswapd0
        119 ?        00:00:00 ecryptfs-kthread
        120 ?        00:00:00 kworker/R-kthro
        129 ?        00:00:00 kworker/R-acpi_
        130 ?        00:00:00 kworker/R-mld
        131 ?        00:00:00 kworker/R-ipv6_
        133 ?        00:00:00 kworker/1:1H-kblockd
        141 ?        00:00:00 kworker/R-kstrp
        143 ?        00:00:00 kworker/u67:0
        151 ?        00:00:00 kworker/R-crypt
        162 ?        00:00:00 kworker/R-charg
        192 ?        00:00:00 kworker/5:1H-kblockd
        203 ?        00:00:00 kworker/11:1H-kblockd
        211 ?        00:00:00 kworker/8:1H-kblockd
        215 ?        00:00:00 kworker/3:1H-kblockd
        216 ?        00:00:00 kworker/7:1H-kblockd
        217 ?        00:00:00 kworker/6:1H-kblockd
        219 ?        00:00:00 kworker/4:1H-kblockd
        220 ?        00:00:00 kworker/10:1H-kblockd
        224 ?        00:00:00 kworker/0:1H-kblockd
        226 ?        00:00:00 kworker/9:1H-kblockd
        230 ?        00:00:00 scsi_eh_0
        231 ?        00:00:00 kworker/R-scsi_
        232 ?        00:00:00 scsi_eh_1
        233 ?        00:00:00 kworker/R-scsi_
        234 ?        00:00:00 scsi_eh_2
        236 ?        00:00:00 kworker/R-scsi_
        237 ?        00:00:00 scsi_eh_3
        238 ?        00:00:00 kworker/R-scsi_
        239 ?        00:00:00 scsi_eh_4
        240 ?        00:00:00 kworker/R-scsi_
        241 ?        00:00:00 scsi_eh_5
        242 ?        00:00:00 kworker/R-scsi_
        243 ?        00:00:00 scsi_eh_6
        244 ?        00:00:00 kworker/R-scsi_
        245 ?        00:00:00 scsi_eh_7
        246 ?        00:00:00 kworker/R-scsi_
        255 ?        00:00:00 scsi_eh_8
        256 ?        00:00:00 kworker/R-scsi_
        257 ?        00:00:00 scsi_eh_9
        258 ?        00:00:00 kworker/R-scsi_
        261 ?        00:00:00 scsi_eh_10
        262 ?        00:00:00 kworker/R-scsi_
        300 ?        00:00:00 scsi_eh_11
        301 ?        00:00:00 kworker/R-scsi_
        302 ?        00:00:00 usb-storage
        303 ?        00:00:00 kworker/R-uas
        334 ?        00:00:00 kworker/R-raid5
        384 ?        00:00:00 jbd2/sdb3-8
        385 ?        00:00:00 kworker/R-ext4-
        447 ?        00:00:00 systemd-journal
        479 ?        00:00:00 kworker/R-rpcio
        480 ?        00:00:00 kworker/R-xprti
        482 ?        00:00:00 kworker/R-nvme-
        483 ?        00:00:00 kworker/R-nvme-
        484 ?        00:00:00 kworker/R-nvme-
        485 ?        00:00:00 kworker/R-nvme-
        535 ?        00:00:00 systemd-udevd
        538 ?        00:00:00 psimon
        920 ?        00:00:00 kworker/R-amdgp
        924 ?        00:00:00 jbd2/sda1-8
        925 ?        00:00:00 kworker/R-ext4-
        929 ?        00:00:00 jbd2/sdb4-8
        930 ?        00:00:00 kworker/R-ext4-
        932 ?        00:00:00 kworker/R-ttm
        934 ?        00:00:00 kworker/R-amdgp
        935 ?        00:00:00 kworker/R-amdgp
        936 ?        00:00:00 kworker/R-amdgp
        937 ?        00:00:00 kworker/R-dm_vb
        938 ?        00:00:00 card1-crtc0
        939 ?        00:00:00 card1-crtc1
        940 ?        00:00:00 card1-crtc2
        941 ?        00:00:00 card1-crtc3
        954 ?        00:00:00 spl_system_task
        955 ?        00:00:00 spl_delay_taskq
        956 ?        00:00:00 spl_dynamic_tas
        957 ?        00:00:00 spl_kmem_cache
        959 ?        00:00:00 zvol
        960 ?        00:00:00 arc_prune
        961 ?        00:00:00 arc_evict
        962 ?        00:00:00 arc_reap
        963 ?        00:00:00 dbu_evict
        964 ?        00:00:00 dbuf_evict
        965 ?        00:00:00 z_vdev_file
        966 ?        00:00:00 l2arc_feed
       1063 ?        00:00:00 rpcbind
       1072 ?        00:00:00 systemd-resolve
       1073 ?        00:00:00 systemd-timesyn
       1087 ?        00:00:00 blkmapd
       1122 ?        00:00:00 nfsdcld
       1164 ?        00:00:00 accounts-daemon
       1169 ?        00:00:00 avahi-daemon
       1173 ?        00:00:00 dbus-daemon
       1176 ?        00:00:00 fsidd
       1180 ?        00:00:01 irqbalance
       1216 ?        00:00:00 polkitd
       1217 ?        00:00:00 power-profiles-
       1223 ?        00:00:00 prometheus-node
       1226 ?        00:00:00 smartd
       1235 ?        00:00:00 switcheroo-cont
       1236 ?        00:00:00 systemd-logind
       1237 ?        00:00:00 systemd-machine
       1239 ?        00:00:03 touchegg
       1250 ?        00:00:02 udisksd
       1252 ?        00:00:00 virtlockd
       1256 ?        00:00:00 virtlogd
       1265 ?        00:00:00 avahi-daemon
       1271 ?        00:00:00 rsyslogd
       1832 ?        00:00:02 NetworkManager
       1838 ?        00:00:00 wpa_supplicant
       1864 ?        00:00:00 ModemManager
       1987 ?        00:00:00 psimon
       1996 ?        00:00:00 cupsd
       2013 ?        00:00:03 containerd
       2029 ?        00:00:00 colord
       2041 ?        00:00:00 winbindd
       2053 ?        00:00:00 wb[A108PC14]
       2113 ?        00:00:00 cups-browsed
       2114 ?        00:00:03 dockerd
       2115 ?        00:00:00 socat
       2125 ?        00:00:00 cron
       2130 ?        00:00:00 rpc.idmapd
       2131 ?        00:00:00 rpc.statd
       2135 ?        00:00:00 rpc.mountd
       2179 ?        00:00:00 kerneloops
       2182 ?        00:00:00 lightdm
       2187 ?        00:00:00 kerneloops
       2192 ?        00:00:00 kworker/R-ipmi-
       2197 ?        00:00:00 lockd
       2214 ?        00:00:00 kworker/R-iprt-
       2217 ?        00:00:00 iprt-VBoxTscThread
       2237 tty7     00:02:07 Xorg
       2240 tty1     00:00:00 agetty
       2244 ?        00:00:00 nfsd
       2245 ?        00:00:00 nfsd
       2246 ?        00:00:00 nfsd
       2247 ?        00:00:00 nfsd
       2248 ?        00:00:00 nfsd
       2249 ?        00:00:00 nfsd
       2250 ?        00:00:00 nfsd
       2251 ?        00:00:00 nfsd
       2297 ?        00:00:00 apache2
       2307 ?        00:00:00 apache2
       2308 ?        00:00:00 apache2
       2309 ?        00:00:00 apache2
       2311 ?        00:00:00 apache2
       2312 ?        00:00:00 apache2
       2354 ?        00:00:00 dnsmasq
       2355 ?        00:00:00 dnsmasq
       2447 ?        00:00:00 rtkit-daemon
       2944 ?        00:00:00 upowerd
       3134 ?        00:00:00 lightdm
       3152 ?        00:00:01 containerd-shim
       3174 ?        00:00:00 apache2
       3247 ?        00:00:00 docker-proxy
       3253 ?        00:00:00 docker-proxy
       3287 ?        00:00:00 apache2
       3288 ?        00:00:00 apache2
       3289 ?        00:00:00 apache2
       3290 ?        00:00:00 apache2
       3291 ?        00:00:00 apache2
       3326 ?        00:00:00 systemd
       3327 ?        00:00:00 (sd-pam)
       3336 ?        00:00:05 pipewire
       3337 ?        00:00:00 pipewire
       3339 ?        00:00:00 powerline-daemo
       3340 ?        00:00:00 wireplumber
       3341 ?        00:00:07 pipewire-pulse
       3342 ?        00:00:00 gnome-keyring-d
       3343 ?        00:00:00 dbus-daemon
       3368 ?        00:00:00 cinnamon-sessio
       3582 ?        00:00:00 csd-automount
       3583 ?        00:00:00 csd-settings-re
       3584 ?        00:00:00 csd-power
       3586 ?        00:00:00 csd-housekeepin
       3589 ?        00:00:00 csd-wacom
       3591 ?        00:00:00 csd-color
       3592 ?        00:00:01 csd-background
       3593 ?        00:00:00 at-spi-bus-laun
       3594 ?        00:00:00 csd-screensaver
       3595 ?        00:00:00 csd-xsettings
       3604 ?        00:00:01 csd-keyboard
       3605 ?        00:00:00 dbus-daemon
       3606 ?        00:00:00 csd-media-keys
       3607 ?        00:00:00 csd-clipboard
       3608 ?        00:00:00 csd-print-notif
       3609 ?        00:00:00 csd-a11y-settin
       3612 ?        00:00:00 dconf-service
       3651 ?        00:00:00 gvfsd
       3663 ?        00:00:00 gvfsd-fuse
       3684 ?        00:00:01 at-spi2-registr
       3685 ?        00:00:00 csd-printer
       3706 ?        00:00:00 gvfs-udisks2-vo
       3715 ?        00:00:00 gvfs-gphoto2-vo
       3720 ?        00:00:00 gvfs-goa-volume
       3725 ?        00:00:00 goa-daemon
       3733 ?        00:00:00 goa-identity-se
       3738 ?        00:00:00 gvfs-mtp-volume
       3745 ?        00:00:00 gvfs-afc-volume
       3752 ?        00:00:00 cinnamon-launch
       3756 ?        00:05:10 cinnamon
       3788 ?        00:00:00 xapp-sn-watcher
       3811 ?        00:00:00 agent
       3822 ?        00:00:00 socat
       3827 ?        00:00:01 nemo-desktop
       3835 ?        00:00:00 evolution-alarm
       3836 ?        00:00:00 cinnamon-killer
       3837 ?        00:00:00 blueman-applet
       3912 ?        00:00:00 evolution-sourc
       3918 ?        00:00:00 obexd
       3947 ?        00:00:00 evolution-calen
       3962 ?        00:00:00 evolution-addre
       3991 ?        00:00:00 gvfsd-trash
       4004 ?        00:00:00 gvfsd-metadata
       4146 ?        00:00:00 xdg-desktop-por
       4166 ?        00:00:00 xdg-document-po
       4170 ?        00:00:00 xdg-permission-
       4177 ?        00:00:00 fusermount3
       4182 ?        00:00:00 xdg-desktop-por
       4190 ?        00:00:00 xdg-desktop-por
       4452 ?        00:00:00 mintUpdate
       4579 ?        00:00:00 applet.py
       4584 ?        00:01:19 mintreport-tray
       7443 ?        00:00:00 nemo
       7464 ?        00:00:12 code
       7468 ?        00:00:00 code
       7469 ?        00:00:00 code
       7471 ?        00:00:00 code
       7490 ?        00:00:00 chrome_crashpad
       7507 ?        00:00:16 code
       7510 ?        00:00:01 code
       7559 ?        00:00:57 code
       7766 ?        00:00:17 code
       7767 ?        00:00:04 code
       7803 ?        00:01:21 code
       8014 ?        00:00:00 code
       8188 ?        00:00:00 code
      12017 ?        00:00:00 apache2
      12056 ?        00:00:00 apache2
      12057 ?        00:00:00 apache2
      12058 ?        00:00:00 apache2
      12059 ?        00:00:00 apache2
      12413 ?        00:00:17 code
      12429 pts/0    00:00:00 bash
      18147 ?        00:13:28 firefox-bin
      18153 ?        00:00:00 crashhelper
      18261 ?        00:00:00 Socket Process
      18274 ?        00:00:25 WebExtensions
      18278 ?        00:00:01 RDD Process
      18304 ?        00:00:09 Privileged Cont
      18379 ?        00:00:01 Utility Process
      18390 ?        00:02:21 Isolated Web Co
      18403 ?        00:00:41 Isolated Web Co
      18516 ?        00:02:27 Isolated Web Co
      18527 ?        00:00:22 Isolated Web Co
      18997 ?        00:00:00 kworker/3:0-mm_percpu_wq
      19689 ?        00:00:00 kworker/2:1-events
      28605 ?        00:00:01 fwupd
      43372 ?        00:00:08 Isolated Web Co
      48326 ?        00:00:00 kworker/5:2-mm_percpu_wq
      50322 ?        00:00:00 kworker/4:1-events
      50339 ?        00:00:00 kworker/8:0-mm_percpu_wq
      50834 ?        00:00:00 zed
      63895 ?        00:00:00 kworker/11:0-mm_percpu_wq
      73014 ?        00:00:20 Isolated Web Co
      83119 ?        00:00:00 kworker/6:1-events
      86364 ?        00:00:01 cinnamon-screen
      99933 ?        00:00:01 gnome-terminal-
      99942 pts/1    00:00:00 bash
     100600 ?        00:00:00 kworker/10:2-events
     100984 ?        00:00:00 kworker/u69:1-ttm
     105056 ?        00:00:00 kworker/u65:1-events_power_efficient
     106852 ?        00:00:00 kworker/2:0-events
     109546 ?        00:00:00 sh
     110392 ?        00:00:00 kworker/R-tls-s
     110394 ?        00:00:00 sh
     112325 ?        00:00:00 kworker/u66:3-events_unbound
     112680 ?        00:00:00 kworker/4:2-rcu_par_gp
     114947 ?        00:00:00 kworker/u65:3-events_power_efficient
     116743 ?        00:00:00 kworker/u69:2-ttm
     116901 ?        00:00:00 kworker/11:2-cgroup_destroy
     120125 ?        00:00:00 kworker/9:0-cgroup_destroy
     120182 ?        00:00:00 kworker/7:0-rcu_gp
     121405 ?        00:00:00 kworker/u68:1-ttm
     125411 ?        00:00:00 kworker/3:1-rcu_par_gp
     125452 ?        00:00:00 kworker/u66:2-events_unbound
     125793 ?        00:00:00 kworker/u68:2-ttm
     125889 ?        00:00:00 kworker/0:1-cgroup_destroy
     126808 ?        00:00:00 kworker/1:2-mm_percpu_wq
     126809 ?        00:00:01 kworker/u64:3-sdma0
     126944 ?        00:00:00 Web Content
     127009 ?        00:00:00 kworker/9:2-mm_percpu_wq
     127060 ?        00:00:00 Web Content
     127063 ?        00:00:00 Web Content
     131501 ?        00:00:00 kworker/1:0-cgroup_destroy
     131563 ?        00:00:00 kworker/u65:0-events_power_efficient
     131803 ?        00:00:00 kworker/u66:0-events_unbound
     132390 ?        00:00:00 kworker/5:1
     132642 ?        00:00:00 kworker/6:0
     133674 ?        00:00:00 kworker/7:1-mm_percpu_wq
     133675 ?        00:00:00 kworker/8:2-events
     133733 ?        00:00:00 kworker/10:0-cgroup_destroy
     135930 ?        00:00:00 kworker/u64:0-gfx_low
     137597 ?        00:00:00 kworker/2:2-mm_percpu_wq
     137598 ?        00:00:00 kworker/3:2-events
     137599 ?        00:00:00 kworker/9:1-rcu_gp
     137600 ?        00:00:00 kworker/9:3
     137638 ?        00:00:00 kworker/8:1
     137639 ?        00:00:00 kworker/4:0-inet_frag_wq
     137675 ?        00:00:00 kworker/u69:0
     137753 ?        00:00:00 kworker/u68:0-ttm
     137754 ?        00:00:00 kworker/u68:3-ttm
     137755 ?        00:00:00 kworker/u68:4
     137785 ?        00:00:00 kworker/u66:1
     137827 ?        00:00:00 kworker/0:2-cgroup_destroy
     137841 ?        00:00:00 kworker/u64:1-gfx_low
     138655 ?        00:00:00 kworker/11:1
     140003 pts/1    00:00:00 ps

    ```
    PID es el identificador, el TTY es indica el termanl asociado con el proceso, el TIME muestra el tiempo total de CPU que el proceso ha utilizado, CMD es el comando que se ha utilizado para iniciar el proceso.
    
16. Ejecuta ps -f y observa la relación entre procesos padre e hijo.
    ```
    UID          PID    PPID  C STIME TTY          TIME CMD
    dam        16906   16897  0 14:58 pts/1    00:00:00 bash
    dam        17123   16906  0 14:58 pts/1    00:00:00 ps -f
    ```
17. Usa ps -axf o pstree para mostrar el árbol de procesos y dibújalo.
    ```
    systemd─┬─ModemManager───3*[{ModemManager}]
        ├─NetworkManager───3*[{NetworkManager}]
        ├─accounts-daemon───3*[{accounts-daemon}]
        ├─agetty
        ├─apache2───5*[apache2]
        ├─at-spi2-registr───3*[{at-spi2-registr}]
        ├─avahi-daemon───avahi-daemon
        ├─blkmapd
        ├─chrome_crashpad───2*[{chrome_crashpad}]
        ├─colord───3*[{colord}]
        ├─containerd───15*[{containerd}]
        ├─containerd-shim─┬─apache2───10*[apache2]
        │                 └─11*[{containerd-shim}]
        ├─cron
        ├─csd-printer───3*[{csd-printer}]
        ├─cups-browsed───3*[{cups-browsed}]
        ├─cupsd
        ├─dbus-daemon
        ├─dnsmasq───dnsmasq
        ├─dockerd─┬─docker-proxy───8*[{docker-proxy}]
        │         ├─docker-proxy───7*[{docker-proxy}]
        │         └─32*[{dockerd}]
        ├─firefox-bin─┬─2*[Isolated Web Co───27*[{Isolated Web Co}]]
        │             ├─Isolated Web Co───30*[{Isolated Web Co}]
        │             ├─Isolated Web Co───29*[{Isolated Web Co}]
        │             ├─Isolated Web Co───26*[{Isolated Web Co}]
        │             ├─Privileged Cont───28*[{Privileged Cont}]
        │             ├─RDD Process───4*[{RDD Process}]
        │             ├─Socket Process───5*[{Socket Process}]
        │             ├─Utility Process───4*[{Utility Process}]
        │             ├─3*[Web Content───18*[{Web Content}]]
        │             ├─WebExtensions───26*[{WebExtensions}]
        │             ├─crashhelper───{crashhelper}
        │             └─114*[{firefox-bin}]
        ├─fsidd
        ├─irqbalance───{irqbalance}
        ├─2*[kerneloops]
        ├─lightdm─┬─Xorg───11*[{Xorg}]
        │         ├─lightdm─┬─cinnamon-sessio─┬─agent───3*[{agent}]
        │         │         │                 ├─applet.py
        │         │         │                 ├─at-spi-bus-laun─┬─dbus-daemon
        │         │         │                 │                 └─4*[{at-spi-bu+
        │         │         │                 ├─blueman-applet───4*[{blueman-ap+
        │         │         │                 ├─cinnamon-killer───4*[{cinnamon-+
        │         │         │                 ├─cinnamon-launch─┬─cinnamon───26+
        │         │         │                 │                 └─6*[{cinnamon-+
        │         │         │                 ├─csd-a11y-settin───4*[{csd-a11y-+
        │         │         │                 ├─csd-automount───4*[{csd-automou+
        │         │         │                 ├─csd-background───4*[{csd-backgr+
        │         │         │                 ├─csd-clipboard───3*[{csd-clipboa+
        │         │         │                 ├─csd-color───4*[{csd-color}]
        │         │         │                 ├─csd-housekeepin───4*[{csd-house+
        │         │         │                 ├─csd-keyboard───4*[{csd-keyboard+
        │         │         │                 ├─csd-media-keys───4*[{csd-media-+
        │         │         │                 ├─csd-power───4*[{csd-power}]
        │         │         │                 ├─csd-print-notif───3*[{csd-print+
        │         │         │                 ├─csd-screensaver───3*[{csd-scree+
        │         │         │                 ├─csd-settings-re───4*[{csd-setti+
        │         │         │                 ├─csd-wacom───3*[{csd-wacom}]
        │         │         │                 ├─csd-xsettings───4*[{csd-xsettin+
        │         │         │                 ├─evolution-alarm───7*[{evolution+
        │         │         │                 ├─nemo-desktop───5*[{nemo-desktop+
        │         │         │                 ├─socat
        │         │         │                 ├─xapp-sn-watcher───4*[{xapp-sn-w+
        │         │         │                 └─4*[{cinnamon-sessio}]
        │         │         └─3*[{lightdm}]
        │         └─3*[{lightdm}]
        ├─mintUpdate───8*[{mintUpdate}]
        ├─mintreport-tray───4*[{mintreport-tray}]
        ├─nemo─┬─code─┬─code───code───22*[{code}]
        │      │      ├─code───code───code───19*[{code}]
        │      │      ├─code───8*[{code}]
        │      │      ├─code───15*[{code}]
        │      │      ├─code───17*[{code}]
        │      │      ├─code─┬─2*[code───7*[{code}]]
        │      │      │      └─15*[{code}]
        │      │      ├─code─┬─bash
        │      │      │      └─16*[{code}]
        │      │      └─36*[{code}]
        │      └─5*[{nemo}]
        ├─nfsdcld
        ├─polkitd───3*[{polkitd}]
        ├─power-profiles-───3*[{power-profiles-}]
        ├─prometheus-node───5*[{prometheus-node}]
        ├─rpc.idmapd
        ├─rpc.mountd
        ├─rpc.statd
        ├─rpcbind
        ├─rsyslogd───3*[{rsyslogd}]
        ├─rtkit-daemon───2*[{rtkit-daemon}]
        ├─smartd
        ├─socat
        ├─switcheroo-cont───3*[{switcheroo-cont}]
        ├─systemd─┬─(sd-pam)
        │         ├─dbus-daemon
        │         ├─dconf-service───3*[{dconf-service}]
        │         ├─evolution-addre───6*[{evolution-addre}]
        │         ├─evolution-calen───9*[{evolution-calen}]
        │         ├─evolution-sourc───4*[{evolution-sourc}]
        │         ├─gnome-keyring-d───4*[{gnome-keyring-d}]
        │         ├─gnome-terminal-─┬─bash───pstree
        │         │                 └─5*[{gnome-terminal-}]
        │         ├─goa-daemon───4*[{goa-daemon}]
        │         ├─goa-identity-se───3*[{goa-identity-se}]
        │         ├─gvfs-afc-volume───4*[{gvfs-afc-volume}]
        │         ├─gvfs-goa-volume───3*[{gvfs-goa-volume}]
        │         ├─gvfs-gphoto2-vo───3*[{gvfs-gphoto2-vo}]
        │         ├─gvfs-mtp-volume───3*[{gvfs-mtp-volume}]
        │         ├─gvfs-udisks2-vo───4*[{gvfs-udisks2-vo}]
        │         ├─gvfsd─┬─gvfsd-trash───4*[{gvfsd-trash}]
        │         │       └─3*[{gvfsd}]
        │         ├─gvfsd-fuse───6*[{gvfsd-fuse}]
        │         ├─gvfsd-metadata───3*[{gvfsd-metadata}]
        │         ├─obexd
        │         ├─2*[pipewire───2*[{pipewire}]]
        │         ├─pipewire-pulse───2*[{pipewire-pulse}]
        │         ├─powerline-daemo
        │         ├─wireplumber───5*[{wireplumber}]
        │         ├─xdg-desktop-por───6*[{xdg-desktop-por}]
        │         ├─2*[xdg-desktop-por───4*[{xdg-desktop-por}]]
        │         ├─xdg-document-po─┬─fusermount3
        │         │                 └─6*[{xdg-document-po}]
        │         └─xdg-permission-───3*[{xdg-permission-}]
        ├─systemd-journal
        ├─systemd-logind
        ├─systemd-machine
        ├─systemd-resolve
        ├─systemd-timesyn───{systemd-timesyn}
        ├─systemd-udevd
        ├─touchegg───3*[{touchegg}]
        ├─udisksd───5*[{udisksd}]
        ├─upowerd───3*[{upowerd}]
        ├─virtlockd
        ├─virtlogd
        ├─winbindd───wb[A108PC14]
        ├─wpa_supplicant
        └─zed───2*[{zed}]
    ```
18. Ejecuta top o htop y localiza el proceso con mayor uso de CPU.
    ```
   PID USUARIO   PR  NI    VIRT    RES    SHR S  %CPU  %MEM     HORA+ ORDEN    
  18147 dam       20   0   11,5g 601616 317212 S  31,9   1,9   0:31.40 firefox+ 
    ```
19. Ejecuta sleep 100 en segundo plano y busca su PID con ps.
    ```
    101465
    ```
20. Finaliza un proceso con kill <PID> y comprueba con ps que ya no está.
    ```
    [1]+  Terminado               sleep 100
    ```

## Bloque 3: Procesos y jerarquía

21. Identifica el **PID del proceso init/systemd** y explica su función.
22. Explica qué ocurre con el **PPID** de un proceso hijo si su padre termina antes.
23. Ejecuta un programa que genere varios procesos hijos y observa sus PIDs con `ps`.
24. Haz que un proceso quede en **estado suspendido** con `Ctrl+Z` y réanúdalo con `fg`.
25. Lanza un proceso en **segundo plano** con `&` y obsérvalo con `jobs`.
26. Explica la diferencia entre los estados de un proceso: **Running, Sleeping, Zombie, Stopped**.
27. Usa `ps -eo pid,ppid,stat,cmd` para mostrar los estados de varios procesos.
28. Ejecuta `watch -n 1 ps -e` y observa cómo cambian los procesos en tiempo real.
29. Explica la diferencia entre ejecutar un proceso con `&` y con `nohup`.
30. Usa `ulimit -a` para ver los límites de recursos de procesos en tu sistema.
