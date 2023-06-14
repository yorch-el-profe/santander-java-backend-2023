package org.bedu.hotel.dto;

import java.util.List;

import lombok.Data;

@Data
public class RoomDTO {

  private long id;
  private String number;
  private List<GuestDTO> guests;
}
