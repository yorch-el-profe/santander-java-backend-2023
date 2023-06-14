package org.bedu.hotel.service;

import java.util.Optional;

import org.bedu.hotel.dto.RoomDTO;
import org.bedu.hotel.dto.room.CreateRoomDTO;

public interface IRoomService {

  Optional<RoomDTO> findById(long id);

  RoomDTO save(CreateRoomDTO data);
}
