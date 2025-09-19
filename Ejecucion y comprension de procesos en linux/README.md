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

12. Usa echo $PPID para mostrar el PID del proceso padre.

13. Ejecuta pidof systemd y explica el resultado.

14. Abre un programa gráfico (ejemplo: gedit) y usa pidof para obtener sus PID.

15. Ejecuta ps -e y explica qué significan sus columnas.

16. Ejecuta ps -f y observa la relación entre procesos padre e hijo.

17. Usa ps -axf o pstree para mostrar el árbol de procesos y dibújalo.

18. Ejecuta top o htop y localiza el proceso con mayor uso de CPU.

19. Ejecuta sleep 100 en segundo plano y busca su PID con ps.

20. Finaliza un proceso con kill <PID> y comprueba con ps que ya no está.



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