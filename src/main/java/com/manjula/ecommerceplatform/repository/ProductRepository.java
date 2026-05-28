package com.manjula.ecommerceplatform.repository;

import com.manjula.ecommerceplatform.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    //Required Queries:
    List<Product> findByCategoryContaining(String category);
    List<Product> findBy
}
