package org.bedu.hotel.controller;

import org.bedu.hotel.dto.GuestDTO;
import org.bedu.hotel.dto.guest.CreateGuestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("guests")
public class GuestController {

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public GuestDTO save(@Valid CreateGuestDTO data) {

  }
}
