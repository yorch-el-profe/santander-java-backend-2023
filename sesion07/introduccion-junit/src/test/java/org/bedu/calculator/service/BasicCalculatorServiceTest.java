package org.bedu.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

// @ExtendWith(SpringExtension.class) -> Pruebas de integración
@ExtendWith(MockitoExtension.class) // -> Pruebas unitarias
public class BasicCalculatorServiceTest {

  // Arrange (Preparación de una prueba)
  @InjectMocks
  private BasicCalculatorService service;

  @Test
  @DisplayName("should return 0 when both values are 0")
  public void sumZeros() {
    // Act (La ejecución del código a probar)
    int result = service.sum(0, 0);

    // Assert (Comprobación del resultado esperado)
    assertEquals(result, 0); // Comprueba igualidad de valores
  }

  @Test
  @DisplayName("should return the same number when right side is zero")
  public void sumWithRightZero() {
    int result = service.sum(100, 0);
    assertEquals(result, 100);
  }

  @Test
  @DisplayName("should return the same number when left side is zero")
  public void sumWithLeftZero() {
    int result = service.sum(0, 80);
    assertEquals(result, 80);
  }
}
