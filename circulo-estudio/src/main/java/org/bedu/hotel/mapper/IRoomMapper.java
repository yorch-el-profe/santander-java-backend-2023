package org.bedu.hotel.mapper;

import org.bedu.hotel.dto.GuestDTO;
import org.bedu.hotel.dto.RoomDTO;
import org.bedu.hotel.dto.room.CreateRoomDTO;
import org.bedu.hotel.entity.Guest;
import org.bedu.hotel.entity.Room;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IRoomMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "guests", ignore = true)
  Room toModel(CreateRoomDTO data);

  @Mapping(target = "guests", ignore = true)
  RoomDTO toDTO(Room data);

  RoomDTO toDTOwithGuests(Room data);

  // Utilizamos el IGuestMapper dentro de IRoomMapper
  default GuestDTO toDTO(Guest data) {
    return Mappers.getMapper(IGuestMapper.class).toDTO(data);
  }
}
