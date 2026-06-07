package com.lexicon.ecommerceplatform.dto;

import com.lexicon.ecommerceplatform.entity.Category;
import com.lexicon.ecommerceplatform.entity.Promotion;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public record ProductResponseDto(
        Long id,
        String name,
        List<String> imgUrls,
        BigDecimal price,
        Category category,
        Set<Promotion> promotions
) {
}
