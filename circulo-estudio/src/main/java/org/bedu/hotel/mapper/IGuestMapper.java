package org.bedu.hotel.mapper;

import org.bedu.hotel.dto.GuestDTO;
import org.bedu.hotel.dto.guest.CreateGuestDTO;
import org.bedu.hotel.dto.guest.UpdateGuestDTO;
import org.bedu.hotel.entity.Guest;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IGuestMapper {

  // Los campos no especificados, se convierten tal cuál su nombre
  // Convierte "telephone" a "phoneNumber"
  @Mapping(source = "telephone", target = "phoneNumber")
  GuestDTO toDTO(Guest data);

  // Ignora el mapeo del campo "id" en Guest
  @Mapping(target = "id", ignore = true)
  @Mapping(source = "phoneNumber", target = "telephone")
  Guest toModel(CreateGuestDTO data);

  @Mapping(target = "id", ignore = true)
  @Mapping(source = "phoneNumber", target = "telephone")
  void toModel(@MappingTarget Guest entity, UpdateGuestDTO data);
}
