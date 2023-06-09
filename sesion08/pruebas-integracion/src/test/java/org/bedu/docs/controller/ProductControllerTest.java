package org.bedu.docs.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// SpringBootTest y SpringExtension habilitan el uso del IoC de Spring
@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class ProductControllerTest {

  // Permite simular las peticiones HTTP
  @Autowired
  private MockMvc mockMvc;

  @Test
  @DisplayName("should return all array data")
  public void findAll() throws Exception {
    mockMvc
        .perform(MockMvcRequestBuilders.get("/products"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string(
            "[{\"code\":\"PR001\",\"name\":\"Gansito\",\"price\":15.0,\"description\":\"Pastelito de chocolate Marinela\"},{\"code\":\"PR002\",\"name\":\"Topochico\",\"price\":19.0,\"description\":\"Agua Mineral de Manantial\"},{\"code\":\"PR003\",\"name\":\"Mazapan\",\"price\":10.0,\"description\":\"Mazapan grande\"}]"));
  }
}
