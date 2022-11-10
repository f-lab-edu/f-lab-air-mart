package com.airmart.ordercommand.domain;

import com.airmart.ordercommand.common.utils.IdentifierGenerator;
import com.airmart.ordercommand.domain.embed.Orders;
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
    private Orders orders = new Orders();
    private Integer minimumQuantity;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @Builder
    public GroupOrder(Integer minimumQuantity,
        LocalDateTime startDate, LocalDateTime endDate, Order order) {
        this.groupOrderId = IdentifierGenerator.randomIdentifier();
        this.minimumQuantity = minimumQuantity;
        this.startDate = startDate;
        this.endDate = endDate;
        order.joinGroupOrder(this);
    }

    public void addOrder(Order order) {
        orders.addOrder(order);
    }

    public void checkGroupOrderSuccess() {
        Long totalQuantity = orders.getTotalQuantity();
        if (minimumQuantity <= totalQuantity) orders.changeToShippingReady();
    }

    /**
     * GroupOrder 에 Status를 Order와 상관 없이 가져가는 방법 고민해볼 필요 있어보임.
     */
    public void validOrderCreation() {
        Long totalQuantity = orders.getTotalQuantity();
        if (minimumQuantity <= totalQuantity) throw new RuntimeException();
    }
}
