package com.airmart.itemservice.itemquery.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntryVO {
    private Long id;
    private Long itemName;
}
