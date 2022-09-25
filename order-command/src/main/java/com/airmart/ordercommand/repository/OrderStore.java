package com.airmart.ordercommand.repository;

import com.airmart.ordercommand.domain.GroupOrder;
import com.airmart.ordercommand.domain.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderStore {
  private final OrderRepository orderRepository;
  private final GroupOrderRepository groupOrderRepository;


  public GroupOrder createGroupOrder(GroupOrder groupOrder) {
    return groupOrderRepository.save(groupOrder);
  }
}
