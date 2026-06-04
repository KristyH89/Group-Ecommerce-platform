package com.manjula.ecommerceplatform.dto;

import com.manjula.ecommerceplatform.dto.OrderItemResponseDto;
import com.manjula.ecommerceplatform.enums.OrderStatus;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class OrderResponseDto {

    private Long orderId;

    private Instant orderDate;

    private OrderStatus status;

    private Long customerId;

    private List<OrderItemResponseDto> items;
}