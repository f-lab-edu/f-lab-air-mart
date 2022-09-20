package com.airmart.ordercommand.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders/command")
public class OrderCommandController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
