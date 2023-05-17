package org.bedu.starter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

import org.bedu.starter.util.Calculadora;

@Configuration
public class ApplicationConfig {

  @Bean
  public Calculadora crearCalculadora() {
    return new Calculadora("Mi calculadora");
  }

  @Bean
  public Scanner crearScanner() {
    return new Scanner(System.in);
  }

  /*
   * @Bean NO ES CORRECTO PORQUE DEPENDEMOS QUE COSAS QUE YA EXISTEN
   * public MainApplication crearAplicacion() {
   * return new MainApplication(this.crearCalculadora(), this.crearScanner());
   * }
   */
}
