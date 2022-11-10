package com.airmart.itemservice.itemquery.repository;

import com.airmart.itemservice.itemquery.domain.entity.ClosingItemList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemQueryRepository extends MongoRepository<ClosingItemList, Long> {
}
