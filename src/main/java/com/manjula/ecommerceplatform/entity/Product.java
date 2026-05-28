package com.manjula.ecommerceplatform.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "products")
public class Product {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String name;

    private List<String> imageUrls;

    @Setter
    private BigDecimal price;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "products_promotions",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name= "promotion_id")
    )
    private Set<Promotion> promotions = new HashSet<>();

    public void addPromotion (Promotion promotion) {
        if (promotions == null) {
            throw new IllegalArgumentException("Promotion cannot be null");
        }
        promotions.add(promotion);
    }

    public void removePromotion (Promotion promotion) {
        if (promotions == null) {
            throw new IllegalArgumentException("Promotion cannot be null");
        }
        promotions.remove(promotion);
    }
}