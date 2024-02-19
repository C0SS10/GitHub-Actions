package com.app.githubactions.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Registro {
  private String nombre;
  private String descripcion;
  private String gravedad;
}
