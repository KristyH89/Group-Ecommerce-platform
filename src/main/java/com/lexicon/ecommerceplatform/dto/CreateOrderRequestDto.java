package com.lexicon.ecommerceplatform.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequestDto {

    @NotNull
    private Long customerId;

    @NotEmpty
    private List<OrderItemRequestDto> items;
}