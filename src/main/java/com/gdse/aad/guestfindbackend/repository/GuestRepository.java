package com.gdse.aad.guestfindbackend.repository;

import com.gdse.aad.guestfindbackend.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    Optional<Guest> findByEmail(String email);
}
