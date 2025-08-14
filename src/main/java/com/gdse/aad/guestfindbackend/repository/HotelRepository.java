package com.gdse.aad.guestfindbackend.repository;

import com.gdse.aad.guestfindbackend.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
