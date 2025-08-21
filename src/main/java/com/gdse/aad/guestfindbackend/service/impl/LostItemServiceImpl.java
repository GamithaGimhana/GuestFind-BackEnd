package com.gdse.aad.guestfindbackend.service.impl;

import com.gdse.aad.guestfindbackend.dto.LostItemRequestDTO;
import com.gdse.aad.guestfindbackend.dto.LostItemResponseDTO;
import com.gdse.aad.guestfindbackend.entity.Guest;
import com.gdse.aad.guestfindbackend.entity.LostItem;
import com.gdse.aad.guestfindbackend.exception.ResourceNotFoundException;
import com.gdse.aad.guestfindbackend.repository.GuestRepository;
import com.gdse.aad.guestfindbackend.repository.LostItemRepository;
import com.gdse.aad.guestfindbackend.service.LostItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LostItemServiceImpl implements LostItemService {

    private final LostItemRepository lostItemRepository;
    private final GuestRepository guestRepository;
    private final ModelMapper modelMapper;

    @Override
    public LostItemResponseDTO createLostItem(LostItemRequestDTO requestDTO) {
        Guest guest = guestRepository.findById(requestDTO.getGuestId())
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found"));

        LostItem lostItem = LostItem.builder()
                .guest(guest)
                .title(requestDTO.getTitle())
                .description(requestDTO.getDescription())
                .imagePath(requestDTO.getImagePath())
                .status(LostItem.Status.PENDING)
                .build();

        LostItem saved = lostItemRepository.save(lostItem);
        return modelMapper.map(saved, LostItemResponseDTO.class);
    }

    @Override
    public LostItemResponseDTO getLostItemById(Long id) {
        LostItem lostItem = lostItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lost item not found"));
        return modelMapper.map(lostItem, LostItemResponseDTO.class);
    }

    @Override
    public List<LostItemResponseDTO> getAllLostItems() {
        List<LostItem> items = lostItemRepository.findAll();
        return items.stream()
                .map(item -> modelMapper.map(item, LostItemResponseDTO.class))
                .toList();
    }

    @Override
    public LostItemResponseDTO updateLostItem(Long id, LostItemRequestDTO requestDTO) {
        LostItem existing = lostItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lost item not found"));

        existing.setTitle(requestDTO.getTitle());
        existing.setDescription(requestDTO.getDescription());
        existing.setImagePath(requestDTO.getImagePath());

        LostItem updated = lostItemRepository.save(existing);
        return modelMapper.map(updated, LostItemResponseDTO.class);
    }

    @Override
    public void deleteLostItem(Long id) {
        LostItem existing = lostItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lost item not found"));
        lostItemRepository.delete(existing);
    }
}
