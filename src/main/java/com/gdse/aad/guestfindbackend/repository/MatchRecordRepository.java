package com.gdse.aad.guestfindbackend.repository;

import com.gdse.aad.guestfindbackend.entity.MatchRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRecordRepository extends JpaRepository<MatchRecord, Long> {
}
