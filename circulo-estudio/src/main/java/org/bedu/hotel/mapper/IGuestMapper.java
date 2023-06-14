package org.bedu.hotel.mapper;

import org.bedu.hotel.dto.GuestDTO;
import org.bedu.hotel.dto.guest.CreateGuestDTO;
import org.bedu.hotel.entity.Guest;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IGuestMapper {

  // Los campos no especificados, se convierten tal cuál su nombre
  // Convierte "telephone" a "phoneNumber"
  @Mapping(source = "telephone", target = "phoneNumber")
  GuestDTO toDTO(Guest data);

  // Ignora el mapeo del campo "id" en Guest
  @Mapping(target = "id", ignore = true)
  @Mapping(source = "phoneNumber", target = "telephone")
  Guest toModel(CreateGuestDTO data);
}
