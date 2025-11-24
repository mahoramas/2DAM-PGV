package com.docencia.semaforo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author mahoramas
 */
public class ColorSemaforo implements Runnable {

    private final String color;

    private static final Semaphore semaforo = new Semaphore(1);
    private static final AtomicBoolean running = new AtomicBoolean(true);

    public ColorSemaforo(String color) {
        this.color = color;
    }

    private long durationMillis() {
        switch (color) {
            case "ROJO":
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
        try {
            while (running.get()) {
                semaforo.acquire();

                if (!running.get()) {
                    semaforo.release();
                    break;
                }

                System.out.println("Color actual: " + color);

                try {
                    Thread.sleep(durationMillis());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    semaforo.release();
                    break;
                }

                semaforo.release();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            semaforo.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread rojo = new Thread(new ColorSemaforo("ROJO"));
        Thread ambar = new Thread(new ColorSemaforo("AMBAR"));
        Thread verde = new Thread(new ColorSemaforo("VERDE"));

        rojo.start();
        ambar.start();
        verde.start();

        Thread.sleep(20000);

        System.out.println("Se terminó el tiempo, finalizando...");
        running.set(false);

        semaforo.release();

        rojo.interrupt();
        ambar.interrupt();
        verde.interrupt();

        rojo.join();
        ambar.join();
        verde.join();

        System.out.println("Finalizado.");
    }
}
