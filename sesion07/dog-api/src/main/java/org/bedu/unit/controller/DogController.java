package org.bedu.unit.controller;

import org.bedu.unit.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dogs")
public class DogController {

  private DogService service;

  @Autowired
  public DogController(DogService service) {
    this.service = service;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public String fetchRandomImage() {
    return service.fetchRandomImage();
  }
}
