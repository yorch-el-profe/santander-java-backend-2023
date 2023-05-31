package org.bedu.lombokdemo.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.bedu.lombokdemo.model.User;
import org.bedu.lombokdemo.service.IDatabaseService;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DatabaseService implements IDatabaseService {

  private List<User> db = new LinkedList<>();

  public User save(User model) {
    log.info(model.toString());
    db.add(model);
    return model;
  }
}
