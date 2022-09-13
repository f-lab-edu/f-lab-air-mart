package com.airmart.itemservice.itemcommand.repository;

import com.airmart.itemservice.itemcommand.domain.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCommandRepository extends JpaRepository<Item, Long> {
}
