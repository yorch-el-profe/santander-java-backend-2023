package org.bedu.jpa.service;

import java.util.List;

import org.bedu.jpa.dto.AuthorDTO;
import org.bedu.jpa.dto.CreateAuthorDTO;

public interface IAuthorService {

  List<AuthorDTO> findAll();

  // AuthorDTO findById(long id);

  AuthorDTO save(CreateAuthorDTO data);
}
