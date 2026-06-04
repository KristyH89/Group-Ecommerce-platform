package com.manjula.ecommerceplatform.dto;

import com.manjula.ecommerceplatform.entity.Category;
import com.manjula.ecommerceplatform.entity.Promotion;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public record ProductResponseDTO(
        Long id,
        String name,
        List<String> imgUrls,
        BigDecimal price,
        Category category,
        Set<Promotion> promotions
) {
}
