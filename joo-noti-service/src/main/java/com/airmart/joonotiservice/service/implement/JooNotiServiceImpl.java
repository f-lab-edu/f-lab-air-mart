package com.airmart.joonotiservice.service.implement;

import com.airmart.joonotiservice.domain.entity.NotificationLog;
import com.airmart.joonotiservice.dto.NotificationDTO;
import com.airmart.joonotiservice.repository.NotificationLogRepository;
import com.airmart.joonotiservice.service.JooNotiService;
import com.airmart.joonotiservice.service.util.NotificationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JooNotiServiceImpl implements JooNotiService {
    private final NotificationLogRepository notificationLogRepository;
    private final NotificationMapper notificationMapper;

    @Override
    public List<NotificationDTO.Response> getNotificationList(String userId) {
        List<NotificationLog> notificationLogList = notificationLogRepository.findAllByUserId(userId);
        return notificationLogList.stream()
                .map(notificationMapper::toDto)
                .collect(Collectors.toList());
    }
}
