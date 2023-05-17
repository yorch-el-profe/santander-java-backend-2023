package org.bedu.starter;

import org.bedu.starter.util.Calculadora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MainApplication {

  private Calculadora c;
  private Scanner sc;

  @Autowired
  public MainApplication(Calculadora c, Scanner sc) {
    this.c = c;
    this.sc = sc;
  }

  public void start() {
    System.out.println("Calculadora");
    System.out.println("1. Sumar");
    System.out.println("2. Restar");
    System.out.println("3. Multiplicar");
    int opcion = sc.nextInt();

    if (opcion > 3 || opcion < 1) {
      System.out.println("Opción inválida");
      return;
    }

    System.out.println("Ingresa el primer número:");
    int a = sc.nextInt();

    System.out.println("Ingresa el segundo número:");
    int b = sc.nextInt();

    int respuesta = 0;

    switch (opcion) {
      case 1:
        respuesta = c.sumar(a, b);
        break;

      case 2:
        respuesta = c.restar(a, b);
        break;

      case 3:
        respuesta = c.multiplicar(a, b);
        break;
    }

    System.out.println("La respuesta es: " + respuesta);
  }
}
