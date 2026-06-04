package com.manjula.ecommerceplatform.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderItemResponseDto {




    private Long productId;


    private String productName;



    private Integer quantity;

   private BigDecimal priceAtPurchase;
}