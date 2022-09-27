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
}
