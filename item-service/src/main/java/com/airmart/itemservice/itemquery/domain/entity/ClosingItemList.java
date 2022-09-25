package com.airmart.itemservice.itemquery.domain.entity;

import com.airmart.itemservice.itemquery.domain.ItemEntryVO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "closing_item_list")
@Data
public class ClosingItemList {
    @Id
    private Long id;
    private List<ItemEntryVO> closingItemList;
}
