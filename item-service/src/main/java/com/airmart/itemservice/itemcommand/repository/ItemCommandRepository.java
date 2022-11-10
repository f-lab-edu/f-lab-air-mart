package com.airmart.itemservice.itemcommand.repository;

import com.airmart.itemservice.itemcommand.domain.Category;
import com.airmart.itemservice.itemcommand.domain.entity.Item;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ItemCommandRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByCategory(Category category, Pageable pageable);
    List<Item> findTop1000ByClosedAtIsAfterOrderByClosedAtAsc(LocalDateTime now);
}
