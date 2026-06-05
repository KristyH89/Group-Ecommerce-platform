package com.lexicon.ecommerceplatform.mapper;

import com.lexicon.ecommerceplatform.dto.ProductRequestDTO;
import com.lexicon.ecommerceplatform.dto.ProductResponseDTO;
import com.lexicon.ecommerceplatform.entity.Category;
import com.lexicon.ecommerceplatform.entity.Product;
import com.lexicon.ecommerceplatform.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class ProductMapper {

    private final CategoryRepository categoryRepository;

    public ProductMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    //Convert ProductRequestDTO to Product entity
    public Product toEntity(ProductRequestDTO request){
        if(request == null) throw new IllegalArgumentException("Product Request cannot be null");
        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        //Find the category by id
        Category category = categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new EntityNotFoundException("Category Not Found"));
        product.setCategory(category);

        return product;
    }

    //Convert Product entity to ProductResponseDTO
    public ProductResponseDTO toResponse(Product product){
        if(product == null) throw new IllegalArgumentException("Product cannot be null");
        ProductResponseDTO productResponseDTO = new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getImageUrls(),
                product.getPrice(),
                product.getCategory(),
                product.getPromotions()
        );

        return productResponseDTO;
    }
}
