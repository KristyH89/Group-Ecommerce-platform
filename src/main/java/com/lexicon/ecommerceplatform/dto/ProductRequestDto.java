package com.lexicon.ecommerceplatform.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductRequestDto(

        @NotBlank(message = "Name cannot be blank")
        @Size(max = 200, message  = "Name must not exceed 200 characters")
        String name,

        @NotEmpty(message = "Price cannot be Empty")
        BigDecimal price,

        @NotEmpty(message = "Category cannot be Empty")
        Long categoryId
) {
}
