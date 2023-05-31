package org.bedu.lombokdemo.dto;

import lombok.Data;

@Data
public class UserDTO {

  private String username;
  // Mapear "email" a "mail"
  private String email;
  // Mapear "pass" a "password"
  private String pass;
  private String address;
  private int age;
  private boolean activated;
}
