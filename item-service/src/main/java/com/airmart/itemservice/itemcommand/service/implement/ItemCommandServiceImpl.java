package com.airmart.itemservice.itemcommand.service.implement;

import com.airmart.itemservice.itemcommand.domain.Category;
import com.airmart.itemservice.itemcommand.domain.entity.Item;
import com.airmart.itemservice.itemcommand.dto.ItemDTO;
import com.airmart.itemservice.itemcommand.repository.ItemCommandRepository;
import com.airmart.itemservice.itemcommand.service.ItemCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemCommandServiceImpl implements ItemCommandService {
    private final ItemCommandRepository itemCommandRepository;
    private final ItemMapper itemMapper;

    @Override
    public List<ItemDTO.Response> getItemList(Category category, Pageable pageable) {
        return itemCommandRepository.findAllByCategory(category, pageable)
                .stream()
                .map(itemMapper::toItemDtoResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void createItem(ItemDTO.Request itemDTO) {
        Item item = itemMapper.toItemEntity(itemDTO);
        itemCommandRepository.save(item);
    }

    @Override
    public void editItem(Long itemId, ItemDTO.Request itemDTO) {
        Item item = itemMapper.toItemEntity(itemDTO);
        item.setId(itemId);
        itemCommandRepository.save(item);
    }

    @Override
    public void deleteItem(Long itemId) {
        itemCommandRepository.deleteById(itemId);
    }
}
