package org.bedu.hotel.dto.guest;

import lombok.Data;

@Data
public class UpdateGuestDTO {

  private String name;
  private Integer age;
  private String phoneNumber;
  private String address;
}
