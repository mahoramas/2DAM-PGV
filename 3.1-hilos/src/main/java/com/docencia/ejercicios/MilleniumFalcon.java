package com.docencia.ejercicios;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author mahoramas
 */
public class MilleniumFalcon {

    private final AtomicBoolean fin = new AtomicBoolean(false);
    private final AtomicBoolean destruida = new AtomicBoolean(false);
    private final int tiempoMisionMS = 4000;
    private long inicio;
    private int velocidad = 0;
    private int escudos = 100;

    private final Runnable HanSolo = () ->{
        while (!fin.get()) {
            velocidad += ThreadLocalRandom.current().nextInt(5, 16);
            if (ThreadLocalRandom.current().nextInt(1, 101) <= 5) {
                destruida.set(true);
                fin.set(true);
                System.out.println("Fallo de hiperimpulsor. ¡La nave se destruye!");
            }
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            if (System.currentTimeMillis() - inicio >= tiempoMisionMS) {
                fin.set(true);
            }
        }
    };

    private final Runnable Chewbacca = () -> {
        while (!fin.get()) {
            escudos += ThreadLocalRandom.current().nextInt(-10, 5);
            if (escudos <= 0) {
                destruida.set(true);
                fin.set(true); 
                System.out.println("¡Escudos agotados! La nave se destruye!");         
            }
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            if (System.currentTimeMillis() - inicio >= tiempoMisionMS) {
                fin.set(true);
            }
        }
    };

    public void main(){
        inicio = System.currentTimeMillis();
        Thread t1 = new Thread(HanSolo);
        Thread t2 = new Thread(Chewbacca);
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        if (!destruida.get()) {
            System.out.println("¡Han y Chewie escapan! Vel=" + velocidad + ", Escudos=" + escudos);
        }
    }
}
