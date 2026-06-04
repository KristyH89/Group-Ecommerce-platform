package com.lexicon.ecommerceplatform.repository;

import com.lexicon.ecommerceplatform.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //Required Queries:
    List<Product> findByCategoryContaining(String category);
    List<Product> findByPriceBetween(BigDecimal priceStart, BigDecimal priceEnd);
}
