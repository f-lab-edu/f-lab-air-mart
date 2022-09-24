package com.airmart.ordercommand.repository;

import com.airmart.ordercommand.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
