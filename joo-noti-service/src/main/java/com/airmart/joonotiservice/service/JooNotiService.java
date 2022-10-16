package com.airmart.joonotiservice.service;

import com.airmart.joonotiservice.dto.NotificationDTO;

import java.util.List;

public interface JooNotiService {
    List<NotificationDTO.Response> getNotificationList();
}
