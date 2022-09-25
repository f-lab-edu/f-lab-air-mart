package com.airmart.itemservice.itemcommand.service;

import com.airmart.itemservice.itemcommand.domain.Category;
import com.airmart.itemservice.itemcommand.dto.ItemCommandDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemCommandService {
    ItemCommandDTO.Response getItemById(Long id);
    List<ItemCommandDTO.Response> getItemList(Category category, Pageable pageable);
    void createItem(ItemCommandDTO.Request itemDTO);
    void editItem(Long itemId, ItemCommandDTO.Request itemDTO);
    void deleteItem(Long itemId);
}
