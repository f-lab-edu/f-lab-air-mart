package com.airmart.ordercommand.domain;

import com.airmart.ordercommand.domain.embed.OrderedItem;
import com.airmart.ordercommand.domain.embed.RecipientInfo;
import com.airmart.ordercommand.domain.embed.SenderInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor @Getter
@Table(name = "orders")
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

    @Enumerated(EnumType.STRING)
    private OrderType orderType;

    @Embedded
    private OrderedItem orderedItem;

    @Embedded
    private RecipientInfo recipientInfo;

    @Embedded
    private SenderInfo senderInfo;

    private String shippingCode;
    /**
     * User 정보필요.
     */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_order_Id")
    private GroupOrder groupOrder;

    public Order(OrderType orderType, OrderedItem orderedItem, RecipientInfo recipientInfo,
        SenderInfo senderInfo) {
        this.orderType = orderType;
        this.orderedItem = orderedItem;
        this.recipientInfo = recipientInfo;
        this.senderInfo = senderInfo;
    }

    public void joinGroupOrder(GroupOrder groupOrder) {
        if (groupOrder == null) throw new RuntimeException();
        this.groupOrder = groupOrder;
        groupOrder.addOrder(this);
    }
}
