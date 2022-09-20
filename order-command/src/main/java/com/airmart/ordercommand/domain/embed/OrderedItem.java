package com.airmart.ordercommand.domain.embed;

import javax.persistence.Embeddable;

@Embeddable
public class OrderedItem {
    /**
     * Item 정보 필요
     */
    private Long quantity;

    private Long price;
}
