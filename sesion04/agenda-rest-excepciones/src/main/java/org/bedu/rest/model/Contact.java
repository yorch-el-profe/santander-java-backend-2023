package org.bedu.rest.model;

import org.bedu.rest.validation.PhoneNumber;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Contact {
  @NotBlank
  @Size(min = 3)
  private String name;

  @PhoneNumber
  private String number;

  public Contact(String name, String number) {
    this.name = name;
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public String getNumber() {
    return number;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setNumber(String number) {
    this.number = number;
  }
}
