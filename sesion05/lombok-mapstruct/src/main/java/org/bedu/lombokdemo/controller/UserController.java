package org.bedu.lombokdemo.controller;

import org.bedu.lombokdemo.dto.UserDTO;
import org.bedu.lombokdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * Niveles de log:
 * info: Mensajes comunes y corrientes
 * error: Mensajes críticos
 * warn: Mensajes de advertencia pero no errores
 */

@Slf4j
@RestController
@RequestMapping("users")
public class UserController {

  private IUserService userService;

  @Autowired
  public UserController(IUserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public void getAll() {
    // TODO
    /*
     * Patrón Builder: Construir objetos complejos a través de llamada de métodos:
     * 
     * En vez de esto:
     * User u = new User("jlasdjlkasd", "jlkjasdlkjasd", "jlkjasdlkjasd",
     * "jlkjasdlkjasd", 0, false);
     * 
     * Se hace esto:
     * User.builder()
     * .username("jlasdjlkasd")
     * .email("jlkjasdlkjasd")
     * .age(100)
     * .activated(false)
     * .build();
     */
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public UserDTO create(@RequestBody UserDTO user) {
    log.warn(user.toString());
    return userService.create(user);
  }
}
