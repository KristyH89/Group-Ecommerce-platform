package com.manjula.ecommerceplatform.service;

import com.manjula.ecommerceplatform.dto.CreateOrderRequestDto;
import com.manjula.ecommerceplatform.dto.OrderItemRequestDto;
import com.manjula.ecommerceplatform.dto.OrderItemResponseDto;
import com.manjula.ecommerceplatform.dto.OrderResponseDto;
import com.manjula.ecommerceplatform.entity.*;
import com.manjula.ecommerceplatform.enums.OrderStatus;
import com.manjula.ecommerceplatform.repository.*;
import com.manjula.ecommerceplatform.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final CustomerRepository customerRepository;

    private final ProductRepository productRepository;

    @Override
    public OrderResponseDto createOrder(
            CreateOrderRequestDto dto
    ) {

        if (dto.getItems() == null ||
                dto.getItems().isEmpty()) {

            throw new RuntimeException(
                    "Order must contain at least one item"
            );
        }

        Customer customer =
                customerRepository.findById(dto.getCustomerId())
                        .orElseThrow(() ->
                                new RuntimeException("Customer not found"));

        Order order = new Order();

        order.setCustomer(customer);

        order.setStatus(OrderStatus.CREATED);

        List<OrderItem> orderItems =
                dto.getItems()
                        .stream()
                        .map(itemDto ->
                                createOrderItem(itemDto, order))
                        .toList();

        order.setItems(orderItems);

        Order savedOrder =
                orderRepository.save(order);

        return mapToResponse(savedOrder);
    }

    private OrderItem createOrderItem(
            OrderItemRequestDto dto,
            Order order
    ) {

        Product product =
                productRepository.findById(dto.getProductId())
                        .orElseThrow(() ->
                                new RuntimeException("Product not found"));

        OrderItem item = new OrderItem();

        item.setOrder(order);

        item.setProduct(product);

        item.setQuantity(dto.getQuantity());

        item.setPriceAtPurchase(product.getPrice());

        return item;
    }

    @Override
    public List<OrderResponseDto> getOrdersByCustomer(
            Long customerId
    ) {

        return orderRepository.findByCustomerId(customerId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private OrderResponseDto mapToResponse(Order order) {

        return OrderResponseDto.builder()
                .orderId(order.getId())
                .orderDate(order.getOrderDate())
                .status(order.getStatus())
                .customerId(order.getCustomer().getId())

                .items(
                        order.getItems()
                                .stream()
                                .map(item ->
                                        OrderItemResponseDto.builder()
                                                .productId(
                                                        item.getProduct().getId()
                                                )
                                                .productName(
                                                        item.getProduct().getName()
                                                )
                                                .quantity(item.getQuantity())
                                                .priceAtPurchase(
                                                        item.getPriceAtPurchase()
                                                )
                                                .build()
                                )
                                .toList()
                )
                .build();
    }
}