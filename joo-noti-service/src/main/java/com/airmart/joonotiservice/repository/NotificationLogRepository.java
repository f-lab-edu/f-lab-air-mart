package com.airmart.joonotiservice.repository;

import com.airmart.joonotiservice.domain.entity.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationLogRepository extends JpaRepository<NotificationLog, Long> {
}
