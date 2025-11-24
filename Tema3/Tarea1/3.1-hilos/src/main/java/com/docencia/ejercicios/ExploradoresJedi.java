package com.docencia.ejercicios;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author mahoramas
 */

public class ExploradoresJedi {

    private final AtomicBoolean pistaEncontrada = new AtomicBoolean(false);
    private final AtomicReference<String> ganador = new AtomicReference<>(null);

    private final Runnable Jedi(String nombre, String planeta) {
        return () -> {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(400, 1501));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        if (!pistaEncontrada.get()) {
            pistaEncontrada.set(true);
            ganador.set(nombre);
            System.out.println(nombre + " halló una pista en " + planeta + ". Fin de búsqueda.");
        }
    };
    }

    public void main(){
        Thread t1 = new Thread(Jedi("Kenobi", "Tatooine"));
        Thread t2 = new Thread(Jedi("Skywalker", "Dagobah"));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


    public boolean isPistaEncontrada() {
        return pistaEncontrada.get();
    }

    public String getGanador() {
        return ganador.get();
    }

    
}
