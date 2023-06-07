package org.bedu.unit.service;

import org.bedu.unit.dto.DogMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DogService {

  private RestTemplate template;

  @Autowired
  public DogService(RestTemplate template) {
    this.template = template;
  }

  public String fetchRandomImage() {
    ResponseEntity<DogMessageDTO> response = template.getForEntity("https://dog.ceo/api/breeds/image/random",
        DogMessageDTO.class);
    return response.getBody().getMessage();
  }
}
