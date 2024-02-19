package com.app.githubactions.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.githubactions.model.Registro;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Generador {
  public void generarReporte(List<Registro> registros, String urlSalida) throws IOException {
    // Lógica para generar reporte
    Document doc = new Document();
    try {
      PdfWriter.getInstance(doc, new FileOutputStream(urlSalida));
      doc.open();

      Map<String, Integer> statsPorGravedad = calcularStatsPorGravedad(registros);
      int totalRegistros = registros.size();

      doc.add(new Paragraph("Informe de fallas\n\n", new Font(Font.FontFamily.TIMES_ROMAN, 20)));
      doc.add(new Paragraph("Total de fallas: " + totalRegistros + "\n\n", new Font(Font.FontFamily.TIMES_ROMAN, 14)));

      doc.add(new Paragraph("Estadísticas por gravedad\n\n", new Font(Font.FontFamily.TIMES_ROMAN, 14)));

      for (Map.Entry<String, Integer> entry : statsPorGravedad.entrySet()) {
        doc.add(new Paragraph(entry.getKey() + ": " + entry.getValue()));
      }

      doc.close();

    } catch (DocumentException e) {
      e.printStackTrace();
    }
  }

  private Map<String, Integer> calcularStatsPorGravedad(List<Registro> registros) {
    Map<String, Integer> statsPorGravedad = new HashMap<>();
    for (Registro registro : registros) {
      String gravedad = registro.getGravedad();
      statsPorGravedad.put(gravedad, statsPorGravedad.getOrDefault(gravedad, 0) + 1);
    }
    return statsPorGravedad;
  }
}
