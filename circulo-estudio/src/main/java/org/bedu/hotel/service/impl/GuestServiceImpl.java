package org.bedu.hotel.service.impl;

import org.bedu.hotel.dto.GuestDTO;
import org.bedu.hotel.dto.guest.CreateGuestDTO;
import org.bedu.hotel.entity.Guest;
import org.bedu.hotel.mapper.IGuestMapper;
import org.bedu.hotel.repository.IGuestRepository;
import org.bedu.hotel.service.IGuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements IGuestService {

  private IGuestRepository repository;
  private IGuestMapper mapper;

  @Autowired
  public GuestServiceImpl(IGuestRepository repository, IGuestMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public GuestDTO save(CreateGuestDTO data) {
    Guest entity = repository.save(mapper.toModel(data));
    return mapper.toDTO(entity);
  }
}
