package com.airmart.joonotiservice.repository;

import com.airmart.joonotiservice.domain.entity.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationLogRepository extends JpaRepository<NotificationLog, Long> {
    List<NotificationLog> findAllByUserId(String userId);
}
