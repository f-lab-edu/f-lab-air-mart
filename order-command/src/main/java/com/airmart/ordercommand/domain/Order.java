package com.airmart.ordercommand.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class Order extends BaseAuditor{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Data Format => YYYYMMDDHHMMSS-UUID
     */
    private String orderId;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
