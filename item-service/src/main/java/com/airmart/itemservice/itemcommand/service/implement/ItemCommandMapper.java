package com.airmart.itemservice.itemcommand.service.implement;

import com.airmart.itemservice.itemcommand.domain.Category;
import com.airmart.itemservice.itemcommand.domain.entity.Item;
import com.airmart.itemservice.itemcommand.dto.ItemCommandDTO;
import org.springframework.stereotype.Service;

@Service
public class ItemCommandMapper {
    public ItemCommandDTO.Response toItemDtoResponse(Item item){
        return ItemCommandDTO.Response.builder()
                .itemId(item.getId())
                .itemName(item.getName())
                .itemPrice(item.getPrice())
                .category(item.getCategory().toString())
                .userName(item.getUserName())
                .build();
    }

    public Item toItemEntity(ItemCommandDTO.Request itemDto){
        return Item.builder()
                .name(itemDto.getItemName())
                .price(itemDto.getItemPrice())
                .userName(itemDto.getUserName())
                .category(Category.valueOf(itemDto.getCategory().toUpperCase()))
                .build();

    }

}
