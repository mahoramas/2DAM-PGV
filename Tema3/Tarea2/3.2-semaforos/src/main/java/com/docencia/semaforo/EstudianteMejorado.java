package com.docencia.semaforo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author mahoramas
 */
public class EstudianteMejorado extends Thread {

    private final String nombre;
    private static final Semaphore semaforoEquipos = new Semaphore(4);

    public EstudianteMejorado(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            semaforoEquipos.acquire();

            int equipoUsado = semaforoEquipos.availablePermits() + 1;

            System.out.println("El estudiante " + nombre +
                    " ha comenzado a utilizar el equipo " + equipoUsado + ".");

            int tiempo = ThreadLocalRandom.current().nextInt(3000, 5001);
            Thread.sleep(tiempo);

            System.out.println("El estudiante " + nombre +
                    " ha finalizado con el equipo " + equipoUsado + ".");

            semaforoEquipos.release();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {

        Thread e1 = new Thread(new EstudianteMejorado("1"));
        Thread e2 = new Thread(new EstudianteMejorado("2"));
        Thread e3 = new Thread(new EstudianteMejorado("3"));
        Thread e4 = new Thread(new EstudianteMejorado("4"));
        Thread e5 = new Thread(new EstudianteMejorado("5"));
        Thread e6 = new Thread(new EstudianteMejorado("6"));

        e1.start(); 
        e2.start();
        e3.start();
        e4.start();
        e5.start();
        e6.start();
    }
}
