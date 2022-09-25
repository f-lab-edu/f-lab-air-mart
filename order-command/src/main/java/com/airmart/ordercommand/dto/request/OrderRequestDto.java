package com.airmart.ordercommand.dto.request;

import com.airmart.ordercommand.domain.GroupOrder;
import com.airmart.ordercommand.domain.Order;
import com.airmart.ordercommand.domain.OrderType;
import com.airmart.ordercommand.domain.embed.OrderedItem;
import com.airmart.ordercommand.domain.embed.RecipientInfo;
import com.airmart.ordercommand.domain.embed.SenderInfo;
import java.time.LocalDateTime;
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
    private Long itemId;
    // 구매 수량
    private Long quantity;

    private long hours;

    private SendInfoRequest sendInfo;

    private RecipientInfoRequest recipientInfo;

    /**
     * price 및 minimumQuantity 는 Item을 통해 발생한다.
     *
     * @return
     */
    public GroupOrder toEntity() {
      LocalDateTime startDate = LocalDateTime.now();
      LocalDateTime endDate = startDate.plusHours(hours);
      GroupOrder groupOrder = GroupOrder.builder()
          .minimumQuantity(0)
          .startDate(startDate)
          .endDate(endDate)
          .build();

      Order newOrder = new Order(
          OrderType.GROUP_ORDER
          , OrderedItem.newInstance(this.quantity, 0L)
          , recipientInfo.toVO()
          , sendInfo.toVo()
      );
      newOrder.joinGroupOrder(groupOrder);
      return groupOrder;
    }
  }

  @Data
  public static class SendInfoRequest {
    private String senderName;
    private String senderPhoneNumber;

    public SenderInfo toVo() {
      return SenderInfo.newInstance(senderName, senderPhoneNumber);
    }
  }
  @Data
  public static class RecipientInfoRequest {
    private String recipientName;
    private String firstAddress;
    private String secondAddress;
    private String zipCode;
    private String recipientPhoneNumber;

    public RecipientInfo toVO() {
      return RecipientInfo.newInstance(recipientName, recipientPhoneNumber
          , firstAddress, secondAddress, zipCode);
    }
  }

}
