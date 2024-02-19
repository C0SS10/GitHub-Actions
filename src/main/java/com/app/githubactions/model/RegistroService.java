package com.app.githubactions.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RegistroService {
  private final ObjectMapper objectMapper = new ObjectMapper();
  private final String filePath;

  public RegistroService(String filePath) {
    this.filePath = filePath;
  }

  public void guardarRegistro(Registro registro) throws IOException{
    List<Registro> registros = leerRegistros();
    registros.add(registro);
    objectMapper.writeValue(new File(filePath), registros);
  }

  public List<Registro> leerRegistros() throws IOException{
    File file = new File(filePath);
    if (!file.exists()) {
      return new ArrayList<>();
    }
    return objectMapper.readValue(file, new TypeReference<List<Registro>>() {});
  }
}
