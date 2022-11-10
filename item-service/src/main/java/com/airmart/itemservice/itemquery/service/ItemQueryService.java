package com.airmart.itemservice.itemquery.service;

import com.airmart.itemservice.itemcommand.dto.ItemCommandDTO;
import com.airmart.itemservice.itemquery.domain.ItemEntryVO;
import com.airmart.itemservice.itemquery.dto.ItemQueryDTO;

import java.util.List;

public interface ItemQueryService {
   ItemQueryDTO.Response getClosingItemList();
   void cachingClosingItems(List<ItemCommandDTO.Response> itemEntryVOList);
}
