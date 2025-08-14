package com.gdse.aad.guestfindbackend.repository;

import com.gdse.aad.guestfindbackend.entity.LostItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LostItemRepository extends JpaRepository<LostItem, Long> {
}
