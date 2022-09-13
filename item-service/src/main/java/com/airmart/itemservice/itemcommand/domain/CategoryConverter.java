package com.airmart.itemservice.itemcommand.domain;

import javax.persistence.AttributeConverter;
import java.util.stream.Stream;

public class CategoryConverter implements AttributeConverter<Category, String> {
    @Override
    public String convertToDatabaseColumn(Category category) {
        if (category == null){
            return null;
        }
        return category.toString();
    }

    @Override
    public Category convertToEntityAttribute(String dbData) {
        if (dbData == null){
            return null;
        }
        return Stream.of(Category.values())
                .filter(category -> category.toString().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
