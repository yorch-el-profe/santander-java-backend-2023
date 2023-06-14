package org.bedu.hotel.service;

import org.bedu.hotel.dto.GuestDTO;
import org.bedu.hotel.dto.guest.CreateGuestDTO;

public interface IGuestService {

  GuestDTO save(CreateGuestDTO data);
}
