package org.bedu.hotel.service.impl;

import java.util.List;
import java.util.Optional;

import org.bedu.hotel.dto.GuestDTO;
import org.bedu.hotel.dto.guest.CreateGuestDTO;
import org.bedu.hotel.dto.guest.UpdateGuestDTO;
import org.bedu.hotel.entity.Guest;
import org.bedu.hotel.exception.GuestNotFoundException;
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

  public List<GuestDTO> findAll() {
    List<Guest> guests = repository.findAll();
    return guests.stream().map(mapper::toDTO).toList();
  }

  public Optional<GuestDTO> findById(long id) {
    Optional<Guest> guest = repository.findById(id);
    return guest.isPresent() ? Optional.of(mapper.toDTO(guest.get())) : Optional.of(null);
  }

  public GuestDTO save(CreateGuestDTO data) {
    Guest entity = repository.save(mapper.toModel(data));
    return mapper.toDTO(entity);
  }

  public void update(long id, UpdateGuestDTO data) {
    Optional<Guest> actual = repository.findById(id);

    if (!actual.isPresent()) {
      throw new GuestNotFoundException();
    }

    Guest guest = actual.get();
    mapper.toModel(guest, data);
    repository.save(guest);
  }

  public void delete(long id) {
    repository.deleteById(id);
  }
}
