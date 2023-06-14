package org.bedu.hotel.dto.guest;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateGuestDTO {

  @NotBlank
  private String name;

  @Min(0)
  @Max(100)
  private int age;

  @Length(min = 8, max = 10)
  private String telephone;

  private String address;
}
