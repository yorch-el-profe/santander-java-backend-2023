package org.bedu.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("test") // Todas las rutas tienene el prefijo "/test"
public class TestController {

  @GetMapping // /test
  @ResponseStatus(HttpStatus.OK)
  public String helloWorld() {
    return "Hello World";
  }

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public String helloWorldPost() {
    return "Hello World (POST)";
  }
}
