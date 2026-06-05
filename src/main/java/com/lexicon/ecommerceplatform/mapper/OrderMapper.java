package com.lexicon.ecommerceplatform.mapper;

import com.lexicon.ecommerceplatform.dto.OrderItemResponseDto;
import com.lexicon.ecommerceplatform.dto.OrderResponseDto;
import com.lexicon.ecommerceplatform.entity.Order;
import com.lexicon.ecommerceplatform.entity.OrderItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMapper {

    public OrderResponseDto toResponseDto(Order order) {

        List<OrderItemResponseDto> itemDtos =
                order.getItems()
                        .stream()
                        .map(this::mapOrderItem)
                        .toList();

        return OrderResponseDto.builder()
                .orderId(order.getId())
                .orderDate(order.getOrderDate())
                .status(order.getStatus())
                .customerId(order.getCustomer().getId())
                .items(itemDtos)
                .build();
    }

    private OrderItemResponseDto mapOrderItem(OrderItem item) {

        return OrderItemResponseDto.builder()
                .productId(item.getProduct().getId())
                .productName(item.getProduct().getName())
                .quantity(item.getQuantity())
                .priceAtPurchase(item.getPriceAtPurchase())
                .build();
    }
}