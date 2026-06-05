package com.lexicon.ecommerceplatform.service;

import com.lexicon.ecommerceplatform.dto.CreateOrderRequestDto;
import com.lexicon.ecommerceplatform.dto.OrderResponseDto;

import java.util.List;

public interface OrderService {

    OrderResponseDto createOrder(CreateOrderRequestDto dto);

    List<OrderResponseDto> getOrdersByCustomer(Long customerId);
}