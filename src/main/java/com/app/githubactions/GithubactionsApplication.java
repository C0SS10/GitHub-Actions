package com.app.githubactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.app.githubactions.utils.ReporteController;

@SpringBootApplication
@ComponentScan(basePackages = {"com.app.githubactions"})
public class GithubactionsApplication {
    @Autowired
    ReporteController reporteController;

    public static void main(String[] args) {
        SpringApplication.run(GithubactionsApplication.class, args);
    }

    public void run(String[] args) {
        if (args.length > 0 && args[0].equals("generar-reporte")) {
            reporteController.generarReporte();
        }
    }

}