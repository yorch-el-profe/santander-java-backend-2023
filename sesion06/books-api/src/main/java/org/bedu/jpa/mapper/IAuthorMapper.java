package org.bedu.jpa.mapper;

import org.bedu.jpa.dto.AuthorDTO;
import org.bedu.jpa.entity.Author;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IAuthorMapper {

  AuthorDTO toDTO(Author entity);
}
