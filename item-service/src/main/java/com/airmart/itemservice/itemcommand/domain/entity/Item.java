package com.airmart.itemservice.itemcommand.domain.entity;

import com.airmart.itemservice.itemcommand.domain.Category;
import com.airmart.itemservice.itemcommand.domain.CategoryConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long price;

    @Convert(converter = CategoryConverter.class)
    private Category category;

}
