package com.airmart.ordercommand.domain;

public enum OrderStatus {
    GROUP_BUYING_INIT("공동 구매"), SHIPPING_READY("배송 준비중"), SHIPPING("배송중")
    , SHIPPING_COMPLETION("배송 완료"), ORDER_CONFIRMATION("구매 확정");

    private String title;

    OrderStatus(String title) {
        this.title = title;
    }
}
