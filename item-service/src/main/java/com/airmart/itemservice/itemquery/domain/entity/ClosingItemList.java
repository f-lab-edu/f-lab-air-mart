package com.airmart.itemservice.itemquery.domain.entity;

import com.airmart.itemservice.itemquery.domain.ItemEntryVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "closing_item_list")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClosingItemList {

    @Transient
    public static final String SEQUENCE_NAME = "closing-item_seq";

    @Id
    private long id;
    private List<ItemEntryVO> closingItemList;
}
