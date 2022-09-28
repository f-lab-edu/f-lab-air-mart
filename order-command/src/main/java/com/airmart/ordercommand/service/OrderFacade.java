package com.airmart.ordercommand.service;

import com.airmart.ordercommand.domain.GroupOrder;
import com.airmart.ordercommand.dto.request.OrderRequestDto.GroupOrderCreateRequest;
import com.airmart.ordercommand.dto.request.OrderRequestDto.OrderCreateRequest;
import com.airmart.ordercommand.dto.response.OrderResponseDto.GroupOrderCreateResponse;
import com.airmart.ordercommand.dto.response.OrderResponseDto.OrderCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderFacade {
  private final OrderService orderService;
  public OrderCreateResponse createOrder(String groupOrderId, OrderCreateRequest request) {
    // GroupOrder 찾기
    // Group 참여 가능여부 체크
    // Order 생성
    // 공구 성공여부 판단후 Order 상태 변경
    //----------------------------  아래부터는 Transaction
    // 결제 - 결제 실패시 대응 작업 진행( Order 상태 원복등 )
    // 성공시 부가 작업 실행
    return null;
  }

  public GroupOrderCreateResponse createGroupOrder(GroupOrderCreateRequest request) {
    // Item 조회, 재고 확인 ( price 와 minimumQuantity 조회 필요 )
    // GroupOrder 와 Order 생성
    GroupOrder groupOrder = orderService.createGroupOrder(request.toEntity(0L, 5));
    // 결제 (paymentService) -> 실패 대응 ( Fallback 패턴 으로 주문 실패로 변경 필요 )
    // Redis 에 정보 쌓기 ? ( 클라우드 공통으로 쓴다고 가정? )
   return null;
  }
}
