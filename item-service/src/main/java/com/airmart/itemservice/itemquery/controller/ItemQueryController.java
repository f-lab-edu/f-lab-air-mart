package com.airmart.itemservice.itemquery.controller;

import com.airmart.itemservice.common.dto.CommonResponse;
import com.airmart.itemservice.itemcommand.dto.ItemCommandDTO;
import com.airmart.itemservice.itemquery.dto.ItemQueryDTO;
import com.airmart.itemservice.itemquery.service.ItemQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemQueryController {

    private final ItemQueryService itemQueryService;

    @GetMapping("/closing")
    public ResponseEntity<CommonResponse<ItemQueryDTO.Response>> getClosingItems(){
        ItemQueryDTO.Response itemList = itemQueryService.getClosingItemList();
        return ResponseEntity.ok().body(CommonResponse.success(itemList));
    }

}
