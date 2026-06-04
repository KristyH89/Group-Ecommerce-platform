package com.manjula.ecommerceplatform.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class OrderItemRequestDto {

    @NotBlank(message = "productId ca not be empty")
    @Size(min = 1, max = 100)
    private Long productId;

    @NotBlank(message = "quantity can  not be empty")
    @Size(min = 1, max = 100)
    private Integer quantity;
}