package com.app.githubactions.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;


import com.app.githubactions.model.Registro;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReporteService {
  private final ObjectMapper objectMapper = new ObjectMapper();

  public List<Registro> cargarRegistrosJSON(String filePath) throws IOException{
    File file = new File(filePath);
    return objectMapper.readValue(file, new TypeReference<List<Registro>>() {});
  }
}
