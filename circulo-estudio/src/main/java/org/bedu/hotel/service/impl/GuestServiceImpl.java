package org.bedu.hotel.service.impl;

import org.bedu.hotel.dto.GuestDTO;
import org.bedu.hotel.dto.guest.CreateGuestDTO;
import org.bedu.hotel.entity.Guest;
import org.bedu.hotel.repository.IGuestRepository;
import org.bedu.hotel.service.IGuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements IGuestService {

  private IGuestRepository repository;

  @Autowired
  public GuestServiceImpl(IGuestRepository repository) {
    this.repository = repository;
  }

  public GuestDTO save(CreateGuestDTO data) {
    Guest g = new Guest();
    g.setAge(data.getAge());
    g.setName(data.getName());

    Guest savedEntity = repository.save(g);

    GuestDTO gd = new GuestDTO();
    gd.setId(savedEntity.getId());
    gd.setName(savedEntity.getName());
    gd.setAge(savedEntity.getAge());

    return gd;
  }
}
