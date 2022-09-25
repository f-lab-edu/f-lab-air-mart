package com.airmart.ordercommand.dto.request;

import com.airmart.ordercommand.domain.embed.Address;
import java.time.Duration;
import javax.persistence.Embedded;
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

  @Data
  public static class GroupOrderCreateRequest {
    /**
     * Format => YYYYMMDDHHMMSS-UUID
     * - Nullable
     */
    private String groupOrderId;

    private Long itemId;

    private Long quantity;

    private long hours;

    private SendInfoRequest sendInfo;

    private RecipientInfoRequest recipientInfo;
  }

  @Data
  public static class SendInfoRequest {
    private String senderName;
    private String senderPhoneNumber;
  }
  @Data
  public static class RecipientInfoRequest {
    private String recipientName;
    private String firstAddress;
    private String secondAddress;
    private String zipCode;
    private String recipientPhoneNumber;
  }

}
