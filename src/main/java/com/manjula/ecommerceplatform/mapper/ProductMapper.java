package com.manjula.ecommerceplatform.mapper;

import com.manjula.ecommerceplatform.dto.ProductRequestDTO;
import com.manjula.ecommerceplatform.dto.ProductResponseDTO;
import com.manjula.ecommerceplatform.entity.Category;
import com.manjula.ecommerceplatform.entity.Product;
import com.manjula.ecommerceplatform.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class ProductMapper {

    private final CategoryRepository categoryRepository;

    public ProductMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    //Convert ProductRequestDTO to Product entity
    public Product toProductEntity(ProductRequestDTO request){
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
    public ProductResponseDTO toProductResponseDTO(Product product){
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
