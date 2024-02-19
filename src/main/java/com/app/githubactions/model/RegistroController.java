package com.app.githubactions.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistroController {
  private RegistroService registroService = new RegistroService("src/main/resources/registros.json");

  @GetMapping("/")
  public String mostrarFormulario() {
    return "index";
  }

  @PostMapping("/registrar-falla")
  public String registrarFalla(
      @RequestParam("descripcion") String descripcion,
      @RequestParam("nombre") String nombre,
      @RequestParam("gravedad") String gravedad) {
    Registro registro = new Registro(descripcion, nombre, gravedad);

    try {
      registroService.guardarRegistro(registro);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return "redirect:/";
  }
}