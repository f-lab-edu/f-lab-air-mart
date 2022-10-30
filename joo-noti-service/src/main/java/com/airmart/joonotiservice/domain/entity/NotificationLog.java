package com.airmart.joonotiservice.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationLog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String notification;

    private boolean readAlready;

    @Column(nullable = false)
    private String userId;

    @Column(columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createdAt;
}
