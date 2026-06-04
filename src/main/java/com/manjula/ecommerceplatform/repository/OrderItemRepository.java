package com.manjula.ecommerceplatform.repository;

import com.manjula.ecommerceplatform.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository
        extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findByOrderId(Long orderId);

    List<OrderItem> findByProductId(Long productId);

    List<OrderItem> findByQuantityGreaterThan(Integer quantity);
}