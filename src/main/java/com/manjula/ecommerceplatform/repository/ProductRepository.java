package com.manjula.ecommerceplatform.repository;

import com.manjula.ecommerceplatform.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    //Required Queries:

}
