package com.airmart.ordercommand.service;

import com.airmart.ordercommand.dto.request.OrderRequestDto;
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
    // Valid 작업 진행 - 재고 확인 필요
    // GroupOrder 가 존재 유무 판단
    //----------------------------  아래부터는 Transaction
    // 있으면 Order 만들어서 Merge 없으면 Group Order 생성후 머지
    // 결제
    // 공구 성공여부 판단
    // 성공시 부가 작업 실행
    return null;
  }

  public GroupOrderCreateResponse createGroupOrder(GroupOrderCreateRequest request) {
    return null;
  }
}
