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
    El proceso init/systemd es el primer proceso que se ejecuta en linux, es el núcleo del sistema operativo en cuanto a la gestión de servicios
22. Explica qué ocurre con el **PPID** de un proceso hijo si su padre termina antes.
    El proceso hijo no cambia inmediatamente, sigue mostrando el PID del proceso padre que ya ha terminado
23. Ejecuta un programa que genere varios procesos hijos y observa sus PIDs con `ps`.
    ```
    ```
24. Haz que un proceso quede en **estado suspendido** con `Ctrl+Z` y réanúdalo con `fg`.
    Si
25. Lanza un proceso en **segundo plano** con `&` y obsérvalo con `jobs`.
    ```
        xeyes
    [1] 119452
    ```
    jobs
    ```
    [1]+  Ejecutando              xeyes &
    ```
26. Explica la diferencia entre los estados de un proceso: **Running, Sleeping, Zombie, Stopped**.
    Un proceso "Running" está en ejecución y consume CPU, un proceso "Sleeping" espera un evento sin consumir CPU un "Zombie" ha terminado pero aún espera ser limpiado por su padre, un "Stopped" está pausado y puede ser reanudado.
27. Usa `ps -eo pid,ppid,stat,cmd` para mostrar los estados de varios procesos.
    ```
            PID    PPID STAT CMD
              1       0 Ss   /sbin/init splash
              2       0 S    [kthreadd]
              3       2 S    [pool_workqueue_release]
              4       2 I<   [kworker/R-rcu_g]
              5       2 I<   [kworker/R-rcu_p]
              6       2 I<   [kworker/R-slub_]
              7       2 I<   [kworker/R-netns]
              8       2 I    [kworker/0:0-events]
             10       2 I<   [kworker/0:0H-events_highpri]
             12       2 I<   [kworker/R-mm_pe]
             13       2 I    [rcu_tasks_kthread]
             14       2 I    [rcu_tasks_rude_kthread]
             15       2 I    [rcu_tasks_trace_kthread]
             16       2 S    [ksoftirqd/0]
             17       2 R    [rcu_preempt]
             18       2 S    [migration/0]
             19       2 S    [idle_inject/0]
             20       2 S    [cpuhp/0]
             21       2 S    [cpuhp/1]
             22       2 S    [idle_inject/1]
             23       2 S    [migration/1]
             24       2 S    [ksoftirqd/1]
             26       2 I<   [kworker/1:0H-events_highpri]
             27       2 S    [cpuhp/2]
             28       2 S    [idle_inject/2]
             29       2 S    [migration/2]
             30       2 S    [ksoftirqd/2]
             32       2 I<   [kworker/2:0H-events_highpri]
             33       2 S    [cpuhp/3]
             34       2 S    [idle_inject/3]
             35       2 S    [migration/3]
             36       2 S    [ksoftirqd/3]
             38       2 I<   [kworker/3:0H-events_highpri]
             39       2 S    [cpuhp/4]
             40       2 S    [idle_inject/4]
             41       2 S    [migration/4]
             42       2 S    [ksoftirqd/4]
             44       2 I<   [kworker/4:0H-events_highpri]
             45       2 S    [cpuhp/5]
             46       2 S    [idle_inject/5]
             47       2 S    [migration/5]
             48       2 S    [ksoftirqd/5]
             50       2 I<   [kworker/5:0H-events_highpri]
             51       2 S    [cpuhp/6]
             52       2 S    [idle_inject/6]
             53       2 S    [migration/6]
             54       2 S    [ksoftirqd/6]
             56       2 I<   [kworker/6:0H-events_highpri]
             57       2 S    [cpuhp/7]
             58       2 S    [idle_inject/7]
             59       2 S    [migration/7]
             60       2 S    [ksoftirqd/7]
             62       2 I<   [kworker/7:0H-events_highpri]
             63       2 S    [cpuhp/8]
             64       2 S    [idle_inject/8]
             65       2 S    [migration/8]
             66       2 S    [ksoftirqd/8]
             68       2 I<   [kworker/8:0H-events_highpri]
             69       2 S    [cpuhp/9]
             70       2 S    [idle_inject/9]
             71       2 S    [migration/9]
             72       2 S    [ksoftirqd/9]
             74       2 I<   [kworker/9:0H-events_highpri]
             75       2 S    [cpuhp/10]
             76       2 S    [idle_inject/10]
             77       2 S    [migration/10]
             78       2 S    [ksoftirqd/10]
             80       2 I<   [kworker/10:0H-events_highpri]
             81       2 S    [cpuhp/11]
             82       2 S    [idle_inject/11]
             83       2 S    [migration/11]
             84       2 S    [ksoftirqd/11]
             86       2 I<   [kworker/11:0H-events_highpri]
             89       2 S    [kdevtmpfs]
             90       2 I<   [kworker/R-inet_]
             92       2 S    [kauditd]
             96       2 S    [khungtaskd]
             98       2 S    [oom_reaper]
             99       2 I<   [kworker/R-write]
            100       2 S    [kcompactd0]
            101       2 SN   [ksmd]
            102       2 SN   [khugepaged]
            103       2 I<   [kworker/R-kinte]
            104       2 I<   [kworker/R-kbloc]
            105       2 I<   [kworker/R-blkcg]
            106       2 S    [irq/9-acpi]
            109       2 I<   [kworker/R-tpm_d]
            110       2 I<   [kworker/R-ata_s]
            111       2 I<   [kworker/R-md]
            112       2 I<   [kworker/R-md_bi]
            113       2 I<   [kworker/R-edac-]
            115       2 I<   [kworker/R-devfr]
            116       2 S    [watchdogd]
            117       2 I<   [kworker/2:1H-kblockd]
            118       2 S    [kswapd0]
            119       2 S    [ecryptfs-kthread]
            120       2 I<   [kworker/R-kthro]
            129       2 I<   [kworker/R-acpi_]
            130       2 I<   [kworker/R-mld]
            131       2 I<   [kworker/R-ipv6_]
            133       2 I<   [kworker/1:1H-kblockd]
            141       2 I<   [kworker/R-kstrp]
            143       2 I<   [kworker/u67:0]
            151       2 I<   [kworker/R-crypt]
            162       2 I<   [kworker/R-charg]
            192       2 I<   [kworker/5:1H-kblockd]
            203       2 I<   [kworker/11:1H-kblockd]
            211       2 I<   [kworker/8:1H-kblockd]
            215       2 I<   [kworker/3:1H-kblockd]
            216       2 I<   [kworker/7:1H-kblockd]
            217       2 I<   [kworker/6:1H-kblockd]
            219       2 I<   [kworker/4:1H-kblockd]
            220       2 I<   [kworker/10:1H-kblockd]
            224       2 I<   [kworker/0:1H-kblockd]
            226       2 I<   [kworker/9:1H-kblockd]
            230       2 S    [scsi_eh_0]
            231       2 I<   [kworker/R-scsi_]
            232       2 S    [scsi_eh_1]
            233       2 I<   [kworker/R-scsi_]
            234       2 S    [scsi_eh_2]
            236       2 I<   [kworker/R-scsi_]
            237       2 S    [scsi_eh_3]
            238       2 I<   [kworker/R-scsi_]
            239       2 S    [scsi_eh_4]
            240       2 I<   [kworker/R-scsi_]
            241       2 S    [scsi_eh_5]
            242       2 I<   [kworker/R-scsi_]
            243       2 S    [scsi_eh_6]
            244       2 I<   [kworker/R-scsi_]
            245       2 S    [scsi_eh_7]
            246       2 I<   [kworker/R-scsi_]
            255       2 S    [scsi_eh_8]
            256       2 I<   [kworker/R-scsi_]
            257       2 S    [scsi_eh_9]
            258       2 I<   [kworker/R-scsi_]
            261       2 S    [scsi_eh_10]
            262       2 I<   [kworker/R-scsi_]
            300       2 S    [scsi_eh_11]
            301       2 I<   [kworker/R-scsi_]
            302       2 S    [usb-storage]
            303       2 I<   [kworker/R-uas]
            334       2 I<   [kworker/R-raid5]
            384       2 S    [jbd2/sdb3-8]
            385       2 I<   [kworker/R-ext4-]
            447       1 S<s  /usr/lib/systemd/systemd-journald
            479       2 I<   [kworker/R-rpcio]
            480       2 I<   [kworker/R-xprti]
            482       2 I<   [kworker/R-nvme-]
            483       2 I<   [kworker/R-nvme-]
            484       2 I<   [kworker/R-nvme-]
            485       2 I<   [kworker/R-nvme-]
            535       1 Ss   /usr/lib/systemd/systemd-udevd
            538       2 S    [psimon]
            920       2 I<   [kworker/R-amdgp]
            924       2 S    [jbd2/sda1-8]
            925       2 I<   [kworker/R-ext4-]
            929       2 S    [jbd2/sdb4-8]
            930       2 I<   [kworker/R-ext4-]
            932       2 I<   [kworker/R-ttm]
            934       2 I<   [kworker/R-amdgp]
            935       2 I<   [kworker/R-amdgp]
            936       2 I<   [kworker/R-amdgp]
            937       2 I<   [kworker/R-dm_vb]
            938       2 S    [card1-crtc0]
            939       2 S    [card1-crtc1]
            940       2 S    [card1-crtc2]
            941       2 S    [card1-crtc3]
            954       2 S<   [spl_system_task]
            955       2 S<   [spl_delay_taskq]
            956       2 S<   [spl_dynamic_tas]
            957       2 S<   [spl_kmem_cache]
            959       2 S<   [zvol]
            960       2 S    [arc_prune]
            961       2 S    [arc_evict]
            962       2 SN   [arc_reap]
            963       2 S    [dbu_evict]
            964       2 SN   [dbuf_evict]
            965       2 SN   [z_vdev_file]
            966       2 S    [l2arc_feed]
           1063       1 Ss   /sbin/rpcbind -f -w
           1072       1 Ss   /usr/lib/systemd/systemd-resolved
           1073       1 Ssl  /usr/lib/systemd/systemd-timesyncd
           1087       1 Ss   /usr/sbin/blkmapd
           1122       1 Ss   /usr/sbin/nfsdcld
           1164       1 Ssl  /usr/libexec/accounts-daemon
           1169       1 Ss   avahi-daemon: running [a108pc14.local]
           1173       1 Ss   @dbus-daemon --system --address=systemd: --nofork --nopidfi
           1176       1 Ss   /usr/sbin/fsidd
           1180       1 Ssl  /usr/sbin/irqbalance
           1216       1 Ssl  /usr/lib/polkit-1/polkitd --no-debug
           1217       1 Ssl  /usr/libexec/power-profiles-daemon
           1223       1 Ssl  /usr/bin/prometheus-node-exporter
           1226       1 Ss   /usr/sbin/smartd -n
           1235       1 Ssl  /usr/libexec/switcheroo-control
           1236       1 Ss   /usr/lib/systemd/systemd-logind
           1237       1 Ss   /usr/lib/systemd/systemd-machined
           1239       1 Ssl  /usr/bin/touchegg --daemon
           1250       1 Ssl  /usr/libexec/udisks2/udisksd
           1252       1 Ss   /usr/sbin/virtlockd
           1256       1 Ss   /usr/sbin/virtlogd
           1265    1169 S    avahi-daemon: chroot helper
           1271       1 Ssl  /usr/sbin/rsyslogd -n -iNONE
           1832       1 Ssl  /usr/sbin/NetworkManager --no-daemon
           1838       1 Ss   /usr/sbin/wpa_supplicant -u -s -O DIR=/run/wpa_supplicant G
           1864       1 Ssl  /usr/sbin/ModemManager
           1987       2 S    [psimon]
           1996       1 Ss   /usr/sbin/cupsd -l
           2013       1 Ssl  /usr/bin/containerd
           2029       1 Ssl  /usr/libexec/colord
           2041       1 Ss   /usr/sbin/winbindd --foreground --no-process-group
           2053    2041 S    winbindd: domain child [A108PC14]
           2113       1 Ssl  /usr/sbin/cups-browsed
           2114       1 Ssl  /usr/bin/dockerd -H fd:// --containerd=/run/containerd/cont
           2115       1 Ss   socat -T 60 openssl-connect:server:789,cafile=/etc/epoptes/
           2125       1 Ss   /usr/sbin/cron -f -P
           2130       1 Ss   /usr/sbin/rpc.idmapd
           2131       1 Ss   /usr/sbin/rpc.statd
           2135       1 Ss   /usr/sbin/rpc.mountd
           2179       1 Ss   /usr/sbin/kerneloops --test
           2182       1 SLsl /usr/sbin/lightdm
           2187       1 Ss   /usr/sbin/kerneloops
           2192       2 I<   [kworker/R-ipmi-]
           2197       2 I    [lockd]
           2214       2 I<   [kworker/R-iprt-]
           2217       2 S    [iprt-VBoxTscThread]
           2237    2182 Ssl+ /usr/lib/xorg/Xorg -core :0 -seat seat0 -auth /var/run/ligh
           2240       1 Ss+  /sbin/agetty -o -p -- \u --noclear - linux
           2244       2 I    [nfsd]
           2245       2 I    [nfsd]
           2246       2 I    [nfsd]
           2247       2 I    [nfsd]
           2248       2 I    [nfsd]
           2249       2 I    [nfsd]
           2250       2 I    [nfsd]
           2251       2 I    [nfsd]
           2297       1 Ss   /usr/sbin/apache2 -k start
           2307    2297 S    /usr/sbin/apache2 -k start
           2308    2297 S    /usr/sbin/apache2 -k start
           2309    2297 S    /usr/sbin/apache2 -k start
           2311    2297 S    /usr/sbin/apache2 -k start
           2312    2297 S    /usr/sbin/apache2 -k start
           2354       1 S    /usr/sbin/dnsmasq --conf-file=/var/lib/libvirt/dnsmasq/defa
           2355    2354 S    /usr/sbin/dnsmasq --conf-file=/var/lib/libvirt/dnsmasq/defa
           2447       1 SNsl /usr/libexec/rtkit-daemon
           2944       1 Ssl  /usr/libexec/upowerd
           3134    2182 Sl   lightdm --session-child 13 20
           3152       1 Sl   /usr/bin/containerd-shim-runc-v2 -namespace moby -id 5df934
           3174    3152 Ss   apache2 -DFOREGROUND
           3247    2114 Sl   /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-por
           3253    2114 Sl   /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 800
           3287    3174 S    apache2 -DFOREGROUND
           3288    3174 S    apache2 -DFOREGROUND
           3289    3174 S    apache2 -DFOREGROUND
           3290    3174 S    apache2 -DFOREGROUND
           3291    3174 S    apache2 -DFOREGROUND
           3326       1 Ss   /usr/lib/systemd/systemd --user
           3327    3326 S    (sd-pam)
           3336    3326 S<sl /usr/bin/pipewire
           3337    3326 Ssl  /usr/bin/pipewire -c filter-chain.conf
           3339    3326 Ss   /usr/bin/python3 /usr/bin/powerline-daemon --foreground
           3340    3326 S<sl /usr/bin/wireplumber
           3341    3326 S<sl /usr/bin/pipewire-pulse
           3342    3326 SLsl /usr/bin/gnome-keyring-daemon --foreground --components=pkc
           3343    3326 Ss   /usr/bin/dbus-daemon --session --address=systemd: --nofork 
           3368    3134 Ssl  /usr/lib/x86_64-linux-gnu/cinnamon-session-binary --session
           3582    3368 Sl   /usr/bin/csd-automount
           3583    3368 Sl   /usr/bin/csd-settings-remap
           3584    3368 Sl   /usr/bin/csd-power
           3586    3368 Sl   /usr/bin/csd-housekeeping
           3589    3368 Sl   /usr/bin/csd-wacom
           3591    3368 Sl   /usr/bin/csd-color
           3592    3368 Sl   /usr/bin/csd-background
           3593    3368 Sl   /usr/libexec/at-spi-bus-launcher --launch-immediately
           3594    3368 Sl   /usr/bin/csd-screensaver-proxy
           3595    3368 Sl   /usr/bin/csd-xsettings
           3604    3368 Sl   /usr/bin/csd-keyboard
           3605    3593 S    /usr/bin/dbus-daemon --config-file=/usr/share/defaults/at-s
           3606    3368 Sl   /usr/bin/csd-media-keys
           3607    3368 Sl   /usr/bin/csd-clipboard
           3608    3368 Sl   /usr/bin/csd-print-notifications
           3609    3368 Sl   /usr/bin/csd-a11y-settings
           3612    3326 Ssl  /usr/libexec/dconf-service
           3651    3326 Ssl  /usr/libexec/gvfsd
           3663    3326 Sl   /usr/libexec/gvfsd-fuse /run/user/1001/gvfs -f
           3684       1 Sl   /usr/libexec/at-spi2-registryd --use-gnome-session
           3685       1 Sl   /usr/libexec/csd-printer
           3706    3326 Ssl  /usr/libexec/gvfs-udisks2-volume-monitor
           3715    3326 Ssl  /usr/libexec/gvfs-gphoto2-volume-monitor
           3720    3326 Ssl  /usr/libexec/gvfs-goa-volume-monitor
           3725    3326 Sl   /usr/libexec/goa-daemon
           3733    3326 Sl   /usr/libexec/goa-identity-service
           3738    3326 Ssl  /usr/libexec/gvfs-mtp-volume-monitor
           3745    3326 Ssl  /usr/libexec/gvfs-afc-volume-monitor
           3752    3368 Sl   cinnamon-launcher
           3756    3752 Sl   cinnamon --replace
           3788    3368 Sl   /usr/lib/x86_64-linux-gnu/xapps/xapp-sn-watcher
           3811    3368 Sl   /usr/libexec/geoclue-2.0/demos/agent
           3822    3368 S    socat -T 60 openssl-connect:server:789,cafile=/etc/epoptes/
           3827    3368 Sl   /usr/bin/nemo-desktop
           3835    3368 Sl   /usr/libexec/evolution-data-server/evolution-alarm-notify
           3836    3368 Sl   cinnamon-killer-daemon
           3837    3368 Sl   /usr/bin/python3 /usr/bin/blueman-applet
           3912    3326 Ssl  /usr/libexec/evolution-source-registry
           3918    3326 Ss   /usr/libexec/bluetooth/obexd
           3947    3326 Ssl  /usr/libexec/evolution-calendar-factory
           3962    3326 Ssl  /usr/libexec/evolution-addressbook-factory
           3991    3651 Sl   /usr/libexec/gvfsd-trash --spawner :1.32 /org/gtk/gvfs/exec
           4004    3326 Ssl  /usr/libexec/gvfsd-metadata
           4146    3326 Ssl  /usr/libexec/xdg-desktop-portal
           4166    3326 Ssl  /usr/libexec/xdg-document-portal
           4170    3326 Ssl  /usr/libexec/xdg-permission-store
           4177    4166 Ss   fusermount3 -o rw,nosuid,nodev,fsname=portal,auto_unmount,s
           4182    3326 Ssl  /usr/libexec/xdg-desktop-portal-xapp
           4190    3326 Ssl  /usr/libexec/xdg-desktop-portal-gtk
           4452       1 Sl   mintUpdate
           4579    3368 S    /usr/bin/python3 /usr/share/system-config-printer/applet.py
           4584       1 Sl   mintreport-tray
           7443       1 Sl   /usr/bin/nemo /home/dam/Descargas/php-docker-project(1).zip
           7464    7443 SLl  /usr/share/code/code /home/dam/Descargas/php-docker-project
           7468    7464 S    /usr/share/code/code --type=zygote --no-zygote-sandbox
           7469    7464 S    /usr/share/code/code --type=zygote
           7471    7469 S    /usr/share/code/code --type=zygote
           7490       1 Sl   /usr/share/code/chrome_crashpad_handler --monitor-self-anno
           7507    7468 Sl   /usr/share/code/code --type=gpu-process --crashpad-handler-
           7510    7464 Sl   /usr/share/code/code --type=utility --utility-sub-type=netw
           7559    7471 Sl   /usr/share/code/code --type=renderer --crashpad-handler-pid
           7766    7464 Sl   /usr/share/code/code --type=utility --utility-sub-type=node
           7767    7464 Sl   /usr/share/code/code --type=utility --utility-sub-type=node
           7803    7464 Sl   /usr/share/code/code --type=utility --utility-sub-type=node
           8014    7803 Sl   /usr/share/code/code /usr/share/code/resources/app/extensio
           8188    7803 Sl   /usr/share/code/code /home/dam/.vscode/extensions/mtxr.sqlt
          12017    3174 S    apache2 -DFOREGROUND
          12056    3174 S    apache2 -DFOREGROUND
          12057    3174 S    apache2 -DFOREGROUND
          12058    3174 S    apache2 -DFOREGROUND
          12059    3174 S    apache2 -DFOREGROUND
          12413    7464 Sl   /usr/share/code/code --type=utility --utility-sub-type=node
          12429   12413 Ss+  /usr/bin/bash --init-file /usr/share/code/resources/app/out
          18147       1 Sl   /usr/lib/firefox/firefox -private-window
          18153   18147 Sl   /usr/lib/firefox/crashhelper 18147 9 /tmp/ 10 12
          18261   18147 Sl   /usr/lib/firefox/firefox-bin -contentproc -parentBuildID 20
          18274   18147 Sl   /usr/lib/firefox/firefox-bin -contentproc -isForBrowser -pr
          18278   18147 Sl   /usr/lib/firefox/firefox-bin -contentproc -parentBuildID 20
          18304   18147 Sl   /usr/lib/firefox/firefox-bin -contentproc -isForBrowser -pr
          18379   18147 Sl   /usr/lib/firefox/firefox-bin -contentproc -parentBuildID 20
          18390   18147 Sl   /usr/lib/firefox/firefox-bin -contentproc -isForBrowser -pr
          18403   18147 Sl   /usr/lib/firefox/firefox-bin -contentproc -isForBrowser -pr
          18516   18147 Sl   /usr/lib/firefox/firefox-bin -contentproc -isForBrowser -pr
          18527   18147 Sl   /usr/lib/firefox/firefox-bin -contentproc -isForBrowser -pr
          18997       2 I    [kworker/3:0-events]
          19689       2 I    [kworker/2:1-events]
          28605       1 Ssl  /usr/libexec/fwupd/fwupd
          43372   18147 Sl   /usr/lib/firefox/firefox-bin -contentproc -isForBrowser -pr
          48326       2 I    [kworker/5:2-events]
          50322       2 I    [kworker/4:1-events]
          50339       2 I    [kworker/8:0-events]
          50564       2 I    [kworker/7:3-rcu_par_gp]
          50834       1 Ssl  zed -F
          62874       2 I    [kworker/0:2-events]
          63895       2 I    [kworker/11:0-events]
          66361   18147 Sl   /usr/lib/firefox/firefox-bin -contentproc -isForBrowser -pr
          72820       2 I    [kworker/9:1-rcu_par_gp]
          73014   18147 Sl   /usr/lib/firefox/firefox-bin -contentproc -isForBrowser -pr
          80696       2 I    [kworker/10:1-events]
          80698       2 I    [kworker/1:0-events]
          83119       2 I    [kworker/6:1-events_freezable]
          86364    3326 Sl   /usr/libexec/cinnamon-screensaver/cinnamon-screensaver-pam-
          93377       2 I    [kworker/6:2-events]
          96372       2 I    [kworker/u65:2-flush-8:16]
          99228       2 I    [kworker/7:1-events]
          99497       2 I    [kworker/8:1-cgroup_destroy]
          99933    3326 Ssl  /usr/libexec/gnome-terminal-server
          99942   99933 Ss   bash
         100600       2 I    [kworker/10:2-inet_frag_wq]
         100984       2 I<   [kworker/u69:1-ttm]
         101569       2 D    [kworker/u66:0+events_unbound]
         105056       2 I    [kworker/u65:1-events_unbound]
         106795       2 I    [kworker/1:2-cgroup_destroy]
         106852       2 I    [kworker/2:0]
         109546    3822 S    epoptes-client
         110392       2 I<   [kworker/R-tls-s]
         110394    2115 S    epoptes-client
         110930       2 I    [kworker/u64:2-gfx_low]
         112325       2 I    [kworker/u66:3-events_power_efficient]
         112680       2 I    [kworker/4:2-events]
         114947       2 I    [kworker/u65:3-events_freezable_power_]
         116554       2 I    [kworker/u64:0-sdma0]
         116617   18147 Sl   /usr/lib/firefox/firefox-bin -contentproc -isForBrowser -pr
         116668   18147 Sl   /usr/lib/firefox/firefox-bin -contentproc -isForBrowser -pr
         116743       2 I<   [kworker/u69:2-ttm]
         116773       2 I<   [kworker/u68:21-ttm]
         116774       2 I<   [kworker/u68:22-ttm]
         116875       2 I    [kworker/u66:2-events_power_efficient]
         116899       2 I    [kworker/5:0-events]
         116900       2 I    [kworker/3:2-cgroup_destroy]
         116901       2 I    [kworker/11:2-events]
         116902       2 I    [kworker/9:2-rcu_par_gp]
         116944   18147 Sl   /usr/lib/firefox/firefox-bin -contentproc -isForBrowser -pr
         116978       2 I    [kworker/6:0]
         119022       2 I    [kworker/u64:1-gfx_low]
         120125       2 I    [kworker/9:0-mm_percpu_wq]
         120182       2 I    [kworker/7:0]
         120184       2 I    [kworker/u65:0-events_unbound]
         120187       2 I    [kworker/1:1]
         120253       2 I    [kworker/u66:1-flush-8:16]
         121063   99942 R+   ps -eo pid,ppid,stat,cmd
    ```
28. Ejecuta `watch -n 1 ps -e` y observa cómo cambian los procesos en tiempo real.
    ```
        PID TTY          TIME CMD
      1 ?        00:00:01 systemd
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
     17 ?        00:00:05 rcu_preempt
     18 ?        00:00:00 migration/0
     19 ?        00:00:00 idle_inject/0
     20 ?        00:00:00 cpuhp/0
     21 ?        00:00:00 cpuhp/1
     22 ?        00:00:00 idle_inject/1
     23 ?        00:00:00 migration/1
    ```
29. Explica la diferencia entre ejecutar un proceso con `&` y con `nohup`.
    & ejecuta un proceso en segundo plano y puede ser terminado si el terminal se cierra, y el nohup desasocia el proceso del terminal, permitiendo que continúe ejecutándose incluso si el terminal se cierra o el usuario se desconecta.
30. Usa `ulimit -a` para ver los límites de recursos de procesos en tu sistema.
    ```
        real-time non-blocking time  (microseconds, -R) unlimited
    core file size              (blocks, -c) 0
    data seg size               (kbytes, -d) unlimited
    scheduling priority                 (-e) 0
    file size                   (blocks, -f) unlimited
    pending signals                     (-i) 125404
    max locked memory           (kbytes, -l) 4026020
    max memory size             (kbytes, -m) unlimited
    open files                          (-n) 1024
    pipe size                (512 bytes, -p) 8
    POSIX message queues         (bytes, -q) 819200
    real-time priority                  (-r) 0
    stack size                  (kbytes, -s) 8192
    cpu time                   (seconds, -t) unlimited
    max user processes                  (-u) 125404
    virtual memory              (kbytes, -v) unlimited
    file locks                          (-x) unlimited
    ```
