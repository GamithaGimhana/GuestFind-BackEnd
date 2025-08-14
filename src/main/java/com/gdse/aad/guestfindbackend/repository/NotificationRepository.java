package com.gdse.aad.guestfindbackend.repository;

import com.gdse.aad.guestfindbackend.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
