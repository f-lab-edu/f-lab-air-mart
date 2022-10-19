package com.airmart.joonotiservice.service.util;

import com.airmart.joonotiservice.domain.entity.NotificationLog;
import com.airmart.joonotiservice.dto.NotificationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationMapper {

    public NotificationDTO.Response toDto(NotificationLog notificationLog){
        return NotificationDTO.Response.builder()
                .notification(notificationLog.getNotification())
                .createdAt(notificationLog.getCreatedAt().toString())
                .read(notificationLog.isRead())
                .build();
    }
}
