package com.airmart.itemservice.itemcommand.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ItemCommandDTO {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        String itemName;
        String userName;
        Long itemPrice;
        String category;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        Long itemId;
        String itemName;
        Long itemPrice;
        String category;
        String userName;
    }
}
