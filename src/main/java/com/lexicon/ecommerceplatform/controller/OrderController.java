package com.lexicon.ecommerceplatform.controller;

import com.lexicon.ecommerceplatform.dto.CreateOrderRequestDto;
import com.lexicon.ecommerceplatform.dto.OrderResponseDto;
import com.lexicon.ecommerceplatform.service.OrderService;
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