package com.airmart.joonotiservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class NotificationDTO {
    @Data @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response{
        private String notification;
        private String createdAt;
        private boolean read;
    }
}
