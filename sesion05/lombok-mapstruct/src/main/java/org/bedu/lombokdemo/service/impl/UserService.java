package org.bedu.lombokdemo.service.impl;

import org.bedu.lombokdemo.dto.UserDTO;
import org.bedu.lombokdemo.mapper.IUserMapper;
import org.bedu.lombokdemo.model.User;
import org.bedu.lombokdemo.service.IDatabaseService;
import org.bedu.lombokdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

  private IDatabaseService db;
  private IUserMapper mapper;

  @Autowired
  public UserService(IDatabaseService db, IUserMapper mapper) {
    this.db = db;
    this.mapper = mapper;
  }

  public UserDTO create(UserDTO data) {
    User newUser = db.save(mapper.toModel(data));
    return mapper.toDTO(newUser);
  }
}
