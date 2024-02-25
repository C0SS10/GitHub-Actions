package com.app.githubactions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.app.githubactions.model.RegistroController;
import com.app.githubactions.model.RegistroService;

@SpringBootTest
@AutoConfigureMockMvc
public class FallaControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Mock
  private RegistroService registroService;

  @InjectMocks
  private RegistroController registroController;

  @Test
  public void testRegistrarFalla() throws Exception {
    // Preparar el escenario
    String nombre = "John";
    String descripcion = "Descripción de la falla";
    String gravedad = "Alta";
    doNothing().when(registroService).guardarRegistro(any());

    // Afirmar que el método registrarFalla redirige a la página principal
    mockMvc.perform(MockMvcRequestBuilders.post("/registrar-falla")
        .param("nombre", nombre)
        .param("descripcion", descripcion)
        .param("gravedad", gravedad))
        .andExpect(MockMvcResultMatchers.redirectedUrl("/"));

    // Actuar
    String result = registroController.registrarFalla(descripcion, nombre, gravedad);

    // Verificar que el método guardarRegistro fue llamado una vez
    assertEquals("redirect:/", result);
    verify(registroService, times(1)).guardarRegistro(any());
  }
}
