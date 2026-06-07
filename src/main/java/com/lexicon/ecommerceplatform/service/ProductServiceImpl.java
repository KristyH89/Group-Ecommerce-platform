package com.lexicon.ecommerceplatform.service;

import com.lexicon.ecommerceplatform.dto.ProductRequestDto;
import com.lexicon.ecommerceplatform.dto.ProductResponseDto;
import com.lexicon.ecommerceplatform.entity.Category;
import com.lexicon.ecommerceplatform.entity.Product;
import com.lexicon.ecommerceplatform.mapper.ProductMapper;
import com.lexicon.ecommerceplatform.repository.CategoryRepository;
import com.lexicon.ecommerceplatform.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper mapper;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper mapper, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.mapper = mapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public ProductResponseDto create(ProductRequestDto request) {
        Category category = categoryRepository.findById(request.categoryId())
                .orElseThrow();

        Product product = mapper.toEntity(request);

        product.setCategory(category);

        Product saved = productRepository.save(product);

        return  mapper.toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponseDto> findAll() {
        return productRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponseDto> searchByName(String name) {
        return productRepository.findByName(name)
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }
}
