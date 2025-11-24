package com.docencia.semaforo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author mahoramas
 */
public class Estudiante extends Thread {

    private final String nombre;
    private static final Semaphore semaforo = new Semaphore(4, true);

    public Estudiante(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            semaforo.acquire();
            System.out.println("El estudiante " + nombre + " ha comenzado a utilizar el equipo.");

            int tiempo = ThreadLocalRandom.current().nextInt(3000, 5001);
            Thread.sleep(tiempo);
            System.out.println("El estudiante " + nombre + " ha finalizado con el equipo.");

            semaforo.release();

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
