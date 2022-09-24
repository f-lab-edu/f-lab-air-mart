package com.airmart.ordercommand.service;

import com.airmart.ordercommand.repository.OrderStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
  private final OrderStore orderStore;


}
