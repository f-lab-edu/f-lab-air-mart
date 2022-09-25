package com.airmart.itemservice.itemquery.service.Implement;

import com.airmart.itemservice.itemquery.dto.ItemQueryDTO;
import com.airmart.itemservice.itemquery.service.ItemQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ItemQueryServiceImpl implements ItemQueryService {

    @Override
    public ItemQueryDTO.Response getClosingItemList() {
        return null;
    }
}
