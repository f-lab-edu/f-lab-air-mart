package com.airmart.itemservice.itemcommand.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {

    @GetMapping
    ResponseEntity<String> getItems(){
        return ResponseEntity.ok("itemList");
    }
}
