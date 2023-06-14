package org.bedu.hotel.repository;

import org.bedu.hotel.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGuestRepository extends JpaRepository<Guest, Long> {
}
