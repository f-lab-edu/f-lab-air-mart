package com.airmart.ordercommand.dto.request;

import lombok.Data;

public class OrderRequestDto {
  @Data
  public static class OrderCreateRequest {

    /**
     * Format => YYYYMMDDHHMMSS-UUID
     * - Nullable
     */
    private String groupOrderId;

    private Long itemId;

    private Long quantity;
    /**
     * 추후 상세 데이터 추가예정.
     */
  }

}
