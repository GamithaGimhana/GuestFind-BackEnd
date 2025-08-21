package com.gdse.aad.guestfindbackend.service.impl;

import com.gdse.aad.guestfindbackend.dto.StaffProfileDTO;
import com.gdse.aad.guestfindbackend.entity.HotelStaff;
import com.gdse.aad.guestfindbackend.repository.HotelStaffRepository;
import com.gdse.aad.guestfindbackend.service.HotelStaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelStaffServiceImpl implements HotelStaffService {

    private final HotelStaffRepository hotelStaffRepository;

    @Override
    public StaffProfileDTO getLoggedInStaffProfile() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        HotelStaff staff = hotelStaffRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Staff not found"));

        return new StaffProfileDTO(
                staff.getName(),
                staff.getEmail(),
                staff.getRole().name(),
                staff.getHotel().getName()
        );
    }

    @Override
    public List<StaffProfileDTO> getAllStaff() {
        return hotelStaffRepository.findAll().stream()
                .map(staff -> new StaffProfileDTO(
                        staff.getName(),
                        staff.getEmail(),
                        staff.getRole().name(),
                        staff.getHotel() != null ? staff.getHotel().getName() : "No Hotel Assigned"
                ))
                .toList();
    }

}
