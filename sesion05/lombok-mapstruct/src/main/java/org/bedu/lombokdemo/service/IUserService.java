package org.bedu.lombokdemo.service;

import org.bedu.lombokdemo.dto.UserDTO;

public interface IUserService {

  UserDTO create(UserDTO user);
}
