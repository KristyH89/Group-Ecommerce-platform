package com.manjula.ecommerceplatform.controller;

import com.manjula.ecommerceplatform.dto.CreateOrderRequestDto;
import com.manjula.ecommerceplatform.dto.OrderResponseDto;
import com.manjula.ecommerceplatform.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public OrderResponseDto createOrder(
            @RequestBody CreateOrderRequestDto dto
    ) {

        return orderService.createOrder(dto);
    }

    @GetMapping("/customer/{customerId}")
    public List<OrderResponseDto> getOrdersByCustomer(
            @PathVariable Long customerId
    ) {

        return orderService.getOrdersByCustomer(customerId);
    }
}