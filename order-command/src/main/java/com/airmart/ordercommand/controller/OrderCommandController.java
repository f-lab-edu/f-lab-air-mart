package com.airmart.ordercommand.controller;

import com.airmart.ordercommand.common.dto.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderCommandController {
    @PostMapping("/hello")
    public String helloPost() {
        return "Hello";
    }

    /**
     *
     * @param groupOrderId : Format => YYYYMMDDHHMMSS-UUID
     * @return CommonResponse
     */
    @PostMapping("/{groupOrderId}")
    public CommonResponse createOrder(
        @PathVariable(required = false) String groupOrderId
    ) {
        return CommonResponse.success();
    }
}
