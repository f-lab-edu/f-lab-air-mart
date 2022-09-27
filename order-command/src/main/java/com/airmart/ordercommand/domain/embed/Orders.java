package com.airmart.ordercommand.domain.embed;

import com.airmart.ordercommand.domain.Order;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;

@Embeddable
public class Orders {
  @OneToMany(mappedBy = "groupOrder", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
  private List<Order> orders = new ArrayList<>();

  public void addOrder(Order order) {
    if (order == null) throw new RuntimeException();
    orders.add(order);
  }

  public Long getTotalQuantity() {
    return orders.stream()
        .map(Order::getQuantity)
        .reduce(Long::sum).orElseThrow(RuntimeException::new);
  }

  public void changeToShippingReady() {
    if (orders.size() == 0) throw new RuntimeException();
    orders.forEach(Order::changeToReady);
  }
}
