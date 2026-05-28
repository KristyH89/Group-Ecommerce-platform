package com.manjula.ecommerceplatform.repository;

import com.manjula.ecommerceplatform.entity.Order;
import com.manjula.ecommerceplatform.enums.OrderStatus;
import org.springframework.data.jpa.repository.*;

import java.time.Instant;
import java.util.List;

public interface OrderRepository
        extends JpaRepository<Order, Long> {

    List<Order> findByCustomerId(Long customerId);

    // N+1 PROBLEM SOLUTION
    @EntityGraph(attributePaths = {"items"})
    List<Order> findByStatus(OrderStatus status);

    List<Order> findByOrderDateAfter(Instant date);

    List<Order> findByOrderDateBetween(
            Instant start,
            Instant end
    );

    long countByStatus(OrderStatus status);

    List<Order> findByCustomerIdAndStatus(
            Long customerId,
            OrderStatus status
    );
}