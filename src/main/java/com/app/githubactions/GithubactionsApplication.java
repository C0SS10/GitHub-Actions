package com.app.githubactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.app.githubactions.utils.ReporteController;

@SpringBootApplication
@ComponentScan(basePackages = { "com.app.githubactions" })
public class GithubactionsApplication {
    @Autowired
    ReporteController reporteController;

    public static void main(String[] args) {
        // Crear y obtener el contexto de la aplicación
        ConfigurableApplicationContext context = SpringApplication.run(GithubactionsApplication.class, args);

        // Verificar si se pasó el argumento "generar-reporte"
        if (args.length > 0 && args[0].equals("generar-reporte")) {
            ReporteController reporteController = context.getBean(ReporteController.class);
            // Llamar al método para generar el reporte
            reporteController.generarReporte();
        }

        // Cerrar el contexto de la aplicación para que en github action continue con el flujo
        context.close();
    }
}