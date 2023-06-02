package org.bedu.jpa.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateAuthorDTO {

  @NotBlank
  private String name;
}
