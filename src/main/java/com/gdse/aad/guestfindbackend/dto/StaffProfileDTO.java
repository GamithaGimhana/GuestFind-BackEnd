package com.gdse.aad.guestfindbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StaffProfileDTO {
    private String name;
    private String email;
    private String role;
    private String hotelName;
}
