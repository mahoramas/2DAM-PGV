package org.docencia.hilos;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SpawnsMundoAbierto {

    static class SpawnTarea implements Runnable {

        private final String[] zonas = {
                "Bosque Maldito",
                "Ruinas Antiguas",
                "Pantano Radiactivo",
                "Ciudad Cibernética",
                "Templo Prohibido"
        };

        private final String[] enemigos = {
                "Slime Mutante",
                "Esqueleto Guerrero",
                "Mecha-Dragón",
                "Bandido del Desierto",
                "Lich Supremo"
        };

        @Override
        public void run() {
            String hilo = Thread.currentThread().getName();
            String zona = zonas[(int)(Math.random() * zonas.length)];
            String enemigo = enemigos[(int)(Math.random() * enemigos.length)];
            System.out.println("[" + LocalTime.now() + "][" + hilo + "] Spawn de " +
                    enemigo + " en " + zona);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        scheduler.scheduleAtFixedRate(new SpawnTarea(), 0, 2, TimeUnit.SECONDS);

        Thread.sleep(12000);

        System.out.println("Deteniendo spawns...");
        scheduler.shutdown();
        if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Forzando parada de spawns.");
            scheduler.shutdownNow();
        }
        System.out.println("Servidor de mundo abierto detenido.");
    }
}
