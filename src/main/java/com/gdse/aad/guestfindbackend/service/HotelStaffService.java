package com.gdse.aad.guestfindbackend.service;

import com.gdse.aad.guestfindbackend.dto.StaffProfileDTO;

import java.util.List;

public interface HotelStaffService {
    StaffProfileDTO getLoggedInStaffProfile();
    List<StaffProfileDTO> getAllStaff();

}
