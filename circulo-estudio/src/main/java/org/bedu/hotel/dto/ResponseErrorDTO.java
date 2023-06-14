package org.bedu.hotel.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseErrorDTO {
  private boolean error;
  private String message;
  private List<String> errors;
}
