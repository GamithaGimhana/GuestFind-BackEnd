package com.gdse.aad.guestfindbackend.repository;

import com.gdse.aad.guestfindbackend.entity.FoundItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoundItemRepository extends JpaRepository<FoundItem, Long> {
}
