package com.docencia.semaforo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author mahoramas
 */
public class ColorSemaforoMejorado implements Runnable {

    private final String color;

    private static final Semaphore semRojo = new Semaphore(1);
    private static final Semaphore semAmbar = new Semaphore(0);
    private static final Semaphore semVerde = new Semaphore(0);

    private static final AtomicBoolean running = new AtomicBoolean(true);

    public ColorSemaforoMejorado(String color) {
        this.color = color;
    }

    private Semaphore mySemaphore() {
        switch (color) {
            case "ROJO":
                return semRojo;
            case "AMBAR":
                return semAmbar;
            case "VERDE":
                return semVerde;
            default:
                throw new IllegalArgumentException("Color desconocido: " + color);
        }
    }

    private Semaphore nextSemaphore() {
        switch (color) {
            case "ROJO":
                return semAmbar;
            case "AMBAR":
                return semVerde;
            case "VERDE":
                return semRojo;
            default:
                throw new IllegalArgumentException("Color desconocido: " + color);
        }
    }

    private long durationMillis() {
        switch (color) {
            case "ROJO":
                return 3000;
            case "VERDE":
                return 3000;
            case "AMBAR":
                return 1000;
            default:
                return 1000;
        }
    }

    @Override
    public void run() {
        Semaphore mine = mySemaphore();
        Semaphore next = nextSemaphore();

        try {
            while (running.get()) {
                mine.acquire();

                if (!running.get()) {
                    next.release();
                    break;
                }

                System.out.println("Color actual: " + color);
                try {
                    Thread.sleep(durationMillis());
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    next.release();
                    break;
                }

                next.release();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            next.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread rojo = new Thread(new ColorSemaforoMejorado("ROJO"));
        Thread verde = new Thread(new ColorSemaforoMejorado("VERDE"));
        Thread ambar = new Thread(new ColorSemaforoMejorado("AMBAR"));
        

        rojo.start();
        verde.start();
        ambar.start();
        

        Thread.sleep(20000);

        System.out.println("Se termino el tiempo, finalizando");
        running.set(false);

        semRojo.release();
        semVerde.release();
        semAmbar.release();
        

        rojo.interrupt();
        verde.interrupt();
        ambar.interrupt();

        rojo.join();
        verde.join();
        ambar.join();
        

        System.out.println("Finalizado");
    }
}
