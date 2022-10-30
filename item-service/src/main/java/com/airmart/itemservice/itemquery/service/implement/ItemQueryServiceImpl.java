package com.airmart.itemservice.itemquery.service.implement;

import com.airmart.itemservice.common.exception.BusinessException;
import com.airmart.itemservice.common.exception.BusinessExceptionDictionary;
import com.airmart.itemservice.itemcommand.dto.ItemCommandDTO;
import com.airmart.itemservice.itemquery.domain.entity.ClosingItemList;
import com.airmart.itemservice.itemquery.dto.ItemQueryDTO;
import com.airmart.itemservice.itemquery.repository.ItemQueryRepository;
import com.airmart.itemservice.itemquery.service.ItemQueryService;
import com.airmart.itemservice.itemquery.service.util.ItemQueryMapper;
import com.airmart.itemservice.itemquery.service.util.SequenceGeneratorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemQueryServiceImpl implements ItemQueryService {

    private final ItemQueryRepository itemQueryRepository;
    private final SequenceGeneratorService sequenceGeneratorService;
    private final ItemQueryMapper itemQueryMapper;
    private static long closingItemSeq = 0L;

    @Override
    public ItemQueryDTO.Response getClosingItemList() {
        ClosingItemList closingItemList = itemQueryRepository
                .findById(closingItemSeq)
                .orElseThrow(() -> {
                    log.error("Closing Item List Seq: " + closingItemSeq);
                    return BusinessException.create(BusinessExceptionDictionary.UNKNOWN);
                });
        return ItemQueryDTO.Response.builder()
                .itemList(closingItemList.getClosingItemList())
                .build();
    }

    @Override
    public void cachingClosingItems(List<ItemCommandDTO.Response> itemList) {
        ClosingItemList closingItemList = ClosingItemList.builder()
                .id(sequenceGeneratorService.generateSequence(ClosingItemList.SEQUENCE_NAME))
                .closingItemList(itemList.stream()
                        .map(itemQueryMapper::toItemEntry)
                        .collect(Collectors.toList()))
                .build();
        itemQueryRepository.save(closingItemList);
        closingItemSeq = closingItemList.getId();
    }
}
