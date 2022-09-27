package com.airmart.ordercommand.service;

import com.airmart.ordercommand.domain.GroupOrder;
import com.airmart.ordercommand.domain.Order;
import com.airmart.ordercommand.repository.OrderStore;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
  private final OrderStore orderStore;

  public GroupOrder createGroupOrder(GroupOrder newOrder) {
    GroupOrder groupOrder = orderStore.createGroupOrder(newOrder);
    // 공구 성공여부 판단 -> 성공시 부가 작업 실행
    groupOrder.checkGroupOrderSuccess();
    return groupOrder;
  }
}
