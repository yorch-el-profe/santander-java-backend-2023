package org.bedu.rest.exception;

public class ContactNotFoundException extends RuntimeException {

  private String name;

  public ContactNotFoundException(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
