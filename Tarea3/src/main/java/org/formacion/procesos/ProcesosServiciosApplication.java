package org.formacion.procesos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author mahoramas
 * @version 1.0.0
 */
@SpringBootApplication
public class ProcesosServiciosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcesosServiciosApplication.class, args);
    }

    /**
     * ejecuta los procesos y avisa cuando ha terminado
     */
    @Bean
    CommandLineRunner demo(Procesos procesos) {
        return args -> {
            System.out.println("Iniciando proceso al arrancar la aplicación...");

            procesos.procesosEnFichero();
            procesos.contarLineas();
            System.out.println("Proceso finalizado.");
        };
    }
}