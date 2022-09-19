package com.airmart.itemservice.itemcommand.service;

import com.airmart.itemservice.itemcommand.domain.Category;
import com.airmart.itemservice.itemcommand.dto.ItemDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemCommandService {
    List<ItemDTO.Response> getItemList(Category category, Pageable pageable);
    void createItem(ItemDTO.Request itemDTO);
    void editItem(Long itemId, ItemDTO.Request itemDTO);
    void deleteItem(Long itemId);
}
