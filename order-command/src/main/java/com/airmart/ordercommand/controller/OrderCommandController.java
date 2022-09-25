package com.airmart.ordercommand.controller;

import static com.airmart.ordercommand.dto.request.OrderRequestDto.*;

import com.airmart.ordercommand.common.dto.CommonResponse;
import com.airmart.ordercommand.dto.response.OrderResponseDto.OrderCreateResponse;
import com.airmart.ordercommand.service.OrderFacade;
import com.airmart.ordercommand.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderCommandController {

    private final OrderFacade orderFacade;
    @PostMapping("/hello")
    public String helloPost() {
        return "Hello";
    }

    /**
     *
     * @param request:OrderCreateRequest
     * @return CommonResponse
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommonResponse<OrderCreateResponse> createOrder(
        @RequestBody OrderCreateRequest request
    ) {
        OrderCreateResponse response = orderFacade.createOrder(request);
        return CommonResponse.success(response);
    }
}
