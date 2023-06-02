package org.bedu.jpa.mapper;

import org.bedu.jpa.dto.AuthorDTO;
import org.bedu.jpa.dto.CreateAuthorDTO;
import org.bedu.jpa.entity.Author;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IAuthorMapper {

  AuthorDTO toDTO(Author entity);

  @Mapping(target = "id", ignore = true)
  Author toModelForSave(CreateAuthorDTO data);
}
