package org.bedu.hotel.service.impl;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.bedu.hotel.dto.RoomDTO;
import org.bedu.hotel.dto.room.CreateRoomDTO;
import org.bedu.hotel.entity.Room;
import org.bedu.hotel.mapper.IRoomMapper;
import org.bedu.hotel.repository.IRoomRepository;
import org.bedu.hotel.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements IRoomService {

  private IRoomRepository repository;
  private IRoomMapper mapper;

  @Autowired
  public RoomServiceImpl(IRoomRepository repository, IRoomMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public Optional<RoomDTO> findById(long id) {
    Optional<Room> room = repository.findByIdWithGuests(id);
    return room.isPresent() ? Optional.of(mapper.toDTOwithGuests(room.get())) : Optional.of(null);
  }

  public RoomDTO save(CreateRoomDTO data) {
    Room room = repository.save(mapper.toModel(data));
    return mapper.toDTO(room);
  }
}
