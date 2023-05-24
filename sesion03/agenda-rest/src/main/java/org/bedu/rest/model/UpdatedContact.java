package org.bedu.rest.model;

public class UpdatedContact {
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
