package org.bedu.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class BasicCalculatorService {

  public int sum(int a, int b) {
    return a + b;
  }

  public int sub(int a, int b) {
    return a - b;
  }
}
