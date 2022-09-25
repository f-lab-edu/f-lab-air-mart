package com.airmart.ordercommand.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderTest {


  @Test
  void 그룹주문_주문_엔티티간_연관관계_맺는_테스트() {
    //given
    Order order = new Order();
    GroupOrder groupOrder = new GroupOrder();
    //when
    order.joinGroupOrder(groupOrder);

    //then
    assertThat(groupOrder.getOrders().get(0)).isEqualTo(order);
    assertThat(order.getGroupOrder()).isEqualTo(groupOrder);
  }

  @Test
  void 그룹주문_주문_엔티티간_연관관계_맺는_테스트_에러케이스() {
    //given
    Order order = new Order();
    GroupOrder groupOrder = null;

    //when,then
    assertThrows(RuntimeException.class, () -> order.joinGroupOrder(groupOrder));
  }
}