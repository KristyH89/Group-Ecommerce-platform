package com.manjula.ecommerceplatform.dto;

import com.manjula.ecommerceplatform.entity.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public record ProductRequestDTO(

        @NotBlank(message = "Name cannot be blank")
        @Size(max = 200, message  = "Name must not exceed 200 characters")
        String name,

        @NotNull(message  = "imageUrls cannot be Null")
        List<String> imageUrls,

        @NotEmpty(message = "Price cannot be blank")
        BigDecimal price,

        @NotNull(message = "Category cannot be Null")
        Category category,

        @NotNull(message = "Promotions cannot be Null")
        Set<Long> promotions
) {
}
