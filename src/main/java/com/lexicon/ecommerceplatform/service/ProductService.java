package com.lexicon.ecommerceplatform;

import com.lexicon.ecommerceplatform.dto.ProductRequestDTO;
import com.lexicon.ecommerceplatform.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    ProductResponseDTO create(ProductRequestDTO productRequestDTO);

    List<ProductResponseDTO> findAll();

    List<ProductResponseDTO> searchByName(String name);
}
