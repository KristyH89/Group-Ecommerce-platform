package com.manjula.ecommerceplatform;

import com.manjula.ecommerceplatform.dto.ProductRequestDTO;
import com.manjula.ecommerceplatform.dto.ProductResponseDTO;
import com.manjula.ecommerceplatform.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ProductResponseDTO create(ProductRequestDTO productRequestDTO);

    List<ProductResponseDTO> findAll();

    List<ProductResponseDTO> searchByName(String name);
}
