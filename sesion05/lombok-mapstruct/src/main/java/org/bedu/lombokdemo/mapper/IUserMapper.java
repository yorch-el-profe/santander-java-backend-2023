package org.bedu.lombokdemo.mapper;

import org.bedu.lombokdemo.dto.UserDTO;
import org.bedu.lombokdemo.model.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IUserMapper {

  // Mapear "pass" a "password"
  @Mapping(source = "pass", target = "password")
  // Mapear "email" a "mail"
  @Mapping(source = "email", target = "mail")
  @Mapping(source = "activated", target = "activated", qualifiedByName = "toYN")
  User toModel(UserDTO dto);

  @Mapping(source = "password", target = "pass")
  @Mapping(source = "mail", target = "email")
  @Mapping(source = "activated", target = "activated", qualifiedByName = "toBoolean")
  UserDTO toDTO(User model);

  @Named("toYN")
  default String toYN(boolean value) {
    return value ? "Y" : "N";
  }

  @Named("toBoolean")
  default boolean toBoolean(String value) {
    return "Y".equals(value);
  }
}
