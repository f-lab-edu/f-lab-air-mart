package com.airmart.itemservice.itemcommand.service.implement;

import com.airmart.itemservice.common.exception.BusinessException;
import com.airmart.itemservice.common.exception.BusinessExceptionDictionary;
import com.airmart.itemservice.itemcommand.domain.Category;
import com.airmart.itemservice.itemcommand.domain.entity.Item;
import com.airmart.itemservice.itemcommand.dto.ItemCommandDTO;
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
    private final ItemCommandMapper itemCommandMapper;

    @Override
    public ItemCommandDTO.Response getItemById(Long id) {
        Item item = itemCommandRepository.findById(id)
                .orElseThrow(() -> BusinessException.create(BusinessExceptionDictionary.UNKNOWN));
        return itemCommandMapper.toItemDtoResponse(item);
    }

    @Override
    public List<ItemCommandDTO.Response> getItemList(Category category, Pageable pageable) {
        return itemCommandRepository.findAllByCategory(category, pageable)
                .stream()
                .map(itemCommandMapper::toItemDtoResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void createItem(ItemCommandDTO.Request itemDTO) {
        Item item = itemCommandMapper.toItemEntity(itemDTO);
        itemCommandRepository.save(item);
    }

    @Override
    public void editItem(Long itemId, ItemCommandDTO.Request itemDTO) {
        Item item = itemCommandMapper.toItemEntity(itemDTO);
        item.setId(itemId);
        itemCommandRepository.save(item);
    }

    @Override
    public void deleteItem(Long itemId) {
        itemCommandRepository.deleteById(itemId);
    }
}
