package com.airmart.ordercommand.domain;

import com.airmart.ordercommand.domain.embed.OrderedItem;
import com.airmart.ordercommand.domain.embed.RecipientInfo;
import com.airmart.ordercommand.domain.embed.SenderInfo;
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
}
