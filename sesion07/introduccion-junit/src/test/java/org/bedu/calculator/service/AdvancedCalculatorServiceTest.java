package org.bedu.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.bedu.calculator.exception.NegativeNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AdvancedCalculatorServiceTest {

  @InjectMocks
  private AdvancedCalculatorService service;

  @Test
  @DisplayName("0! = 1")
  public void zeroFactorial() {
    int result = service.factorial(0);
    assertEquals(result, 1);
  }

  @Test
  @DisplayName("-n! doesnt exist")
  public void negativeFactorial() {
    assertThrows(NegativeNumberException.class, () -> service.factorial(-1));
  }

  @Test
  @DisplayName("10! = 3628800")
  public void tenFactorial() {
    int result = service.factorial(10);
    assertEquals(result, 3628800);
  }
}
