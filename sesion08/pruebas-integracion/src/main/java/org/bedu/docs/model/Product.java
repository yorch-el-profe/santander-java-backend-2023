package org.bedu.docs.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

  private String code;
  private String name;
  private float price;
  private String description;
}
