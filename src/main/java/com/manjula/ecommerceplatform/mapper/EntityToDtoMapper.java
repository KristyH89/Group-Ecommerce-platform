package com.manjula.ecommerceplatform.mapper;

import com.manjula.ecommerceplatform.dto.ProductRequestDTO;
import com.manjula.ecommerceplatform.dto.ProductResponseDTO;
import com.manjula.ecommerceplatform.entity.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class EntityToDtoMapper {

    //Convert ProductRequestDTO to Product entity
    public Product toProductEntity(ProductRequestDTO productRequestDTO){
        if(productRequestDTO == null) throw new IllegalArgumentException("Product Request cannot be null");
        Product product = new Product();
        product.setName(productRequestDTO.name());
        product.setPrice(productRequestDTO.price());
        //product.set Find a solution for the category id
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
