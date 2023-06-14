package org.bedu.hotel.dto.room;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateRoomDTO {

  @NotBlank
  private String number;
}
