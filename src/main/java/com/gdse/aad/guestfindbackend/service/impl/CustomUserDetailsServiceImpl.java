package com.gdse.aad.guestfindbackend.service.impl;

import com.gdse.aad.guestfindbackend.entity.HotelStaff;
import com.gdse.aad.guestfindbackend.repository.HotelStaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private final HotelStaffRepository hotelStaffRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        HotelStaff staff = hotelStaffRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                staff.getEmail(),
                staff.getPasswordHash(),
                List.of(new SimpleGrantedAuthority("ROLE_" + staff.getRole().name()))
        );
    }
}
