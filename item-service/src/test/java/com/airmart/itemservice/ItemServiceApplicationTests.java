package com.airmart.itemservice;

import com.airmart.itemservice.itemcommand.domain.Category;
import com.airmart.itemservice.itemcommand.domain.entity.Item;
import com.airmart.itemservice.itemcommand.repository.ItemCommandRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItemServiceApplicationTests {

	private final ItemCommandRepository itemCommandRepository;

	@Autowired
	ItemServiceApplicationTests(ItemCommandRepository itemCommandRepository) {
		this.itemCommandRepository = itemCommandRepository;
	}

	@Test
	void contextLoads() {
		System.out.println(Category.HEALTH);
		Item newItem = Item.builder().name("test").price(1111L)
				.category(Category.HEALTH)
				.build();
		itemCommandRepository.save(newItem);
	}

}
