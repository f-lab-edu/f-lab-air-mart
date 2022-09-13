package com.airmart.itemservice.itemcommand.dto;

import lombok.Data;

public class ItemDTO {

    public static class Request {

    }

    @Data
    public static class Response {
        Long itemId;
        String itemName;
        Long itemPrice;
    }
}
