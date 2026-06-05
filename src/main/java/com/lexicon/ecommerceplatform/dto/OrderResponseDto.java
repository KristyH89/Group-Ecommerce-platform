package com.lexicon.ecommerceplatform.dto;

import com.lexicon.ecommerceplatform.enums.OrderStatus;
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