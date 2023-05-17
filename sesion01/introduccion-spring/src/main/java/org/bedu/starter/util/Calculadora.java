package org.bedu.starter.util;

public class Calculadora {

  private String nombre;

  public Calculadora(String nombre) {
    this.nombre = nombre;
  }

  public int sumar(int a, int b) {
    return a + b;
  }

  public int restar(int a, int b) {
    return a - b;
  }

  public int multiplicar(int a, int b) {
    return a * b;
  }
}
