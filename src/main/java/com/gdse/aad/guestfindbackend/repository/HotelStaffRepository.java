package com.gdse.aad.guestfindbackend.repository;

import com.gdse.aad.guestfindbackend.entity.HotelStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface HotelStaffRepository extends JpaRepository<HotelStaff, Long> {
    Optional<HotelStaff> findByEmail(String email);
}
