package com.gdse.aad.guestfindbackend.service;

import com.gdse.aad.guestfindbackend.dto.LostItemRequestDTO;
import com.gdse.aad.guestfindbackend.dto.LostItemResponseDTO;

import java.util.List;

public interface LostItemService {
    LostItemResponseDTO createLostItem(LostItemRequestDTO requestDTO);
    LostItemResponseDTO getLostItemById(Long id);
    List<LostItemResponseDTO> getAllLostItems();
    LostItemResponseDTO updateLostItem(Long id, LostItemRequestDTO requestDTO);
    void deleteLostItem(Long id);
}
