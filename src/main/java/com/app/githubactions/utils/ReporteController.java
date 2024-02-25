package com.app.githubactions.utils;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.githubactions.model.Registro;

import java.io.IOException;
import java.util.List;

@RestController
public class ReporteController {
    private final ReporteService reporteService;
    private final Generador generador;
    private final String rutaRegistros = "src/main/resources/registros.json";
    private final String rutaReporte = "src/main/resources/reporte.pdf";

    public ReporteController(ReporteService reporteService, Generador generador) {
        this.reporteService = reporteService;
        this.generador = generador;
    }
    
    @GetMapping("/generar-reporte")
    public String generarReporte() {
        try {
            List<Registro> registros = reporteService.cargarRegistrosJSON(rutaRegistros);
            generador.generarReporte(registros, rutaReporte);
            return "Reporte generado correctamente";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al generar reporte: " + e.getMessage();
        }
    }
}
