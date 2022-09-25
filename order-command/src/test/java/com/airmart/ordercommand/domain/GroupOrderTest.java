package com.airmart.ordercommand.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GroupOrderTest {

  @Test
  @DisplayName("주문 추가 로직 작성")
  void 주문_추가_테스트() {
    //given
    GroupOrder groupOrder = new GroupOrder();
    Order order = new Order();

    //when
    assertThat(groupOrder.getOrders().size()).isEqualTo(0);
    groupOrder.addOrder(order);

    //then
    assertThat(groupOrder.getOrders().size()).isEqualTo(1);
  }

  @Test
  @DisplayName("주문 추가 테스트 - 주문이 Null 일 때")
  void 주문_추가_테스트_에러_케이스() {
    //given
    GroupOrder groupOrder = new GroupOrder();
    Order order = null;

    //when
    assertThat(groupOrder.getOrders().size()).isEqualTo(0);

    //then
    assertThrows(RuntimeException.class, () -> groupOrder.addOrder(order));
  }
}