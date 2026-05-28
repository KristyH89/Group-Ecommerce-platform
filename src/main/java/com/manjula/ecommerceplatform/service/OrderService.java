package com.manjula.ecommerceplatform.service;

import com.manjula.ecommerceplatform.dto.CreateOrderRequestDto;
import com.manjula.ecommerceplatform.dto.OrderResponseDto;

import java.util.List;

public interface OrderService {

    OrderResponseDto createOrder(CreateOrderRequestDto dto);

    List<OrderResponseDto> getOrdersByCustomer(Long customerId);
}