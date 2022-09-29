package com.airmart.ordercommand.domain.embed;

import java.util.Optional;
import javax.persistence.Embeddable;
import lombok.Getter;

@Embeddable
public class OrderedItem {
    /**
     * Item 정보 필요
     */
    private Long quantity;

    private Long price;

    public OrderedItem() {
    }

    private OrderedItem(Long quantity, Long price) {
        this.quantity = quantity;
        this.price = price;
    }

    public static OrderedItem newInstance(Long quantity, Long price) {
        return new OrderedItem(quantity, price);
    }

    public Optional<Long> getQuantity() {
        return Optional.of(quantity);
    }
}
