package org.bedu.hotel.dto;

import lombok.Data;

@Data
public class GuestDTO {

  private long id;
  private String name;
  private int age;
  private String phoneNumber;
  private String address;
}
