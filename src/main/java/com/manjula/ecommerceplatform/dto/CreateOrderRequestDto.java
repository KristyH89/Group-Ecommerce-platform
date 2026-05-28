package com.manjula.ecommerceplatform.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequestDto {

    private Long customerId;

    private List<OrderItemRequestDto> items;
}