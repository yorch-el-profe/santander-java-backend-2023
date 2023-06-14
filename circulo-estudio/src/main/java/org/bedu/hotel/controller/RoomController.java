package org.bedu.hotel.controller;

import java.util.Optional;

import org.bedu.hotel.dto.RoomDTO;
import org.bedu.hotel.dto.room.CreateRoomDTO;
import org.bedu.hotel.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("rooms")
public class RoomController {

  private IRoomService service;

  @Autowired
  public RoomController(IRoomService service) {
    this.service = service;
  }

  @GetMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public Optional<RoomDTO> findById(@PathVariable("id") long id) {
    return service.findById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public RoomDTO save(@Valid @RequestBody CreateRoomDTO data) {
    return service.save(data);
  }
}
