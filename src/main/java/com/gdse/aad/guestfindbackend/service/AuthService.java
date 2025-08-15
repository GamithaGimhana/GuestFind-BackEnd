package com.gdse.aad.guestfindbackend.service;

import com.gdse.aad.guestfindbackend.dto.AuthDTO;
import com.gdse.aad.guestfindbackend.dto.AuthResponseDTO;
import com.gdse.aad.guestfindbackend.dto.RegisterDTO;

public interface AuthService {
    AuthResponseDTO authenticate(AuthDTO authDTO);
    String register(RegisterDTO registerDTO);
}
