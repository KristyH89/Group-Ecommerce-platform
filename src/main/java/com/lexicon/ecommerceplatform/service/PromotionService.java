package com.lexicon.ecommerceplatform.service;

import com.lexicon.ecommerceplatform.dto.PromotionResponseDto;
import com.lexicon.ecommerceplatform.entity.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface PromotionService {

    /**
     * Returns all promotions whose date range includes today.
     */
    List<PromotionResponseDto> getActivePromotions();

    /**
     * Finds the best active promotion for the given product and returns the
     * discounted price. Returns the original price when no active promotion applies.
     */
    BigDecimal calculateDiscount(Product product);
}
