package com.airmart.itemservice.itemquery.service.util;

import com.airmart.itemservice.itemcommand.dto.ItemCommandDTO;
import com.airmart.itemservice.itemquery.domain.ItemEntryVO;
import org.springframework.stereotype.Service;

@Service
public class ItemQueryMapper {
    public ItemEntryVO toItemEntry(ItemCommandDTO.Response item){
        return ItemEntryVO.builder()
                .id(item.getItemId())
                .itemName(item.getItemName())
                .closeTime(item.getClosingDateTime())
                .build();
    }
}
