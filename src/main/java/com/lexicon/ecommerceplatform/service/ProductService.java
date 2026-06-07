package com.lexicon.ecommerceplatform.service;

import com.lexicon.ecommerceplatform.dto.ProductRequestDto;
import com.lexicon.ecommerceplatform.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto create(ProductRequestDto productRequestDTO);

    List<ProductResponseDto> findAll();

    List<ProductResponseDto> searchByName(String name);
}
