package org.bedu.jpa.service.impl;

import org.bedu.jpa.repository.IAuthorRepository;
import org.bedu.jpa.service.IAuthorService;

import java.util.LinkedList;
import java.util.List;

import org.bedu.jpa.dto.AuthorDTO;
import org.bedu.jpa.dto.CreateAuthorDTO;
import org.bedu.jpa.entity.Author;
import org.bedu.jpa.mapper.IAuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements IAuthorService {

  private IAuthorRepository repository;
  private IAuthorMapper mapper;

  @Autowired
  public AuthorServiceImpl(IAuthorRepository repository, IAuthorMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public List<AuthorDTO> findAll() {
    List<Author> authors = repository.findAll();

    // Manera pro (funcional)
    // return authors.stream().map(mapper::toDTO).toList();

    // Manera aburrida
    List<AuthorDTO> dtos = new LinkedList<>();

    for (Author author : authors) {
      dtos.add(mapper.toDTO(author));
    }

    return dtos;
  }

  public AuthorDTO save(CreateAuthorDTO data) {
    Author author = repository.save(mapper.toModelForSave(data));
    return mapper.toDTO(author);
  }
}
