package org.bedu.calculator.service;

import org.bedu.calculator.exception.NegativeNumberException;
import org.springframework.stereotype.Service;

@Service
public class AdvancedCalculatorService {

  // Para todo número "n" >= 0
  // n! = n * (n-1) * (n-2) * (n-3) * ... * 1
  // 5! = 5 * 4 * 3 * 2 * 1
  public int factorial(int n) throws NegativeNumberException {
    int result = 1;

    if (n < 0) {
      throw new NegativeNumberException();
    }

    for (int i = n; i > 1; i--) {
      result *= i; // result = result * i
    }

    return result;
  }
}
