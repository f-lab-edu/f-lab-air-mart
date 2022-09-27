package com.airmart.ordercommand.domain;

import com.airmart.ordercommand.domain.embed.Orders;
import java.time.LocalDateTime;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class GroupOrder extends BaseAuditor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Data Format => YYYYMMDDHHMMSS-UUID
     */
    private String groupOrderId;
    @Embedded
    private Orders orders;
    private Integer minimumQuantity;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @Builder
    public GroupOrder(Integer minimumQuantity,
        LocalDateTime startDate, LocalDateTime endDate, Order order) {
        this.minimumQuantity = minimumQuantity;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void addOrder(Order order) {
        orders.addOrder(order);
    }
}
