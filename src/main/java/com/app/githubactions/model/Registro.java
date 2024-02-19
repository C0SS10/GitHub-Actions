package com.app.githubactions.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Registro {
  private String nombre;
  private String descripcion;
  private String gravedad;
}
