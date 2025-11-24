package org.docencia.hilos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CalculadoraDanoCritico {

    static class Ataque {
        final String atacante;
        final int danoBase;
        final double probCritico;
        final double multiplicadorCritico; 

        Ataque(String atacante, int danoBase, double probCritico, double multiplicadorCritico) {
            this.atacante = atacante;
            this.danoBase = danoBase;
            this.probCritico = probCritico;
            this.multiplicadorCritico = multiplicadorCritico;
        }
    }

    static class TareaCalcularDano implements Callable<Integer> {
        private final Ataque ataque;

        TareaCalcularDano(Ataque ataque) {
            this.ataque = ataque;
        }

        @Override
        public Integer call() throws Exception {
            String hilo = Thread.currentThread().getName();
            System.out.println("[" + hilo + "] Calculando danio para " + ataque.atacante);

            boolean esCritico = Math.random() < ataque.probCritico;
            double multiplicador = esCritico ? ataque.multiplicadorCritico : 1.0;

            Thread.sleep(500 + (int)(Math.random() * 500));

            int danoFinal = (int) (ataque.danoBase * multiplicador);
            System.out.println("[" + hilo + "] " + ataque.atacante +
                    (esCritico ? " ¡CRITICO!" : " golpe normal") +
                    " -> danio: " + danoFinal);

            return danoFinal;
        }
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        List<Future<Integer>> futuros = new ArrayList<>();

        Ataque[] ataques = {
                new Ataque("Mago del Fuego", 120, 0.30, 2.5),
                new Ataque("Guerrero", 150, 0.15, 2.0),
                new Ataque("Picaro", 90, 0.50, 3.0),
                new Ataque("Arquera Elfica", 110, 0.35, 2.2),
                new Ataque("Invocador", 80, 0.40, 2.8),
                new Ataque("Paladin", 130, 0.10, 1.8),
                new Ataque("Barbaro", 160, 0.20, 2.1),
                new Ataque("Nigromante", 100, 0.25, 2.3),
        };

        for (Ataque ataque : ataques) {
            Future<Integer> futuro = pool.submit(new TareaCalcularDano(ataque));
            futuros.add(futuro);
        }

        int totalRaid = 0;
        for (int i = 0; i < ataques.length; i++) {
            try {
                int dano = futuros.get(i).get(); 
                totalRaid += dano;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Lectura de resultado interrumpida");
            } catch (ExecutionException e) {
                System.out.println("Error calculando danio: " + e.getCause());
            }
        }

        System.out.println("Danio total de la raid: " + totalRaid);
        pool.shutdown();
    }
}
