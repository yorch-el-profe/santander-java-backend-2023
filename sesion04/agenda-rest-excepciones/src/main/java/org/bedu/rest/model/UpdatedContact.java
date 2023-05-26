package org.bedu.rest.model;

import org.bedu.rest.validation.PhoneNumber;

public class UpdatedContact {

  @PhoneNumber
  private String number;

  public UpdatedContact() {

  }

  public UpdatedContact(String number) {
    this.number = number;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }
}
