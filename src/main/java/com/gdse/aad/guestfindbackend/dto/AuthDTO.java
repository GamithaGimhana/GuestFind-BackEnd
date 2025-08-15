package com.gdse.aad.guestfindbackend.dto;

import lombok.Data;

@Data
public class AuthDTO {
    private String username; // email of staff
    private String password;
}
