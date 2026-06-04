package com.lexicon.ecommerceplatform.service;

import com.lexicon.ecommerceplatform.dto.PromotionResponseDto;
import com.lexicon.ecommerceplatform.entity.Product;
import com.lexicon.ecommerceplatform.entity.Promotion;
import com.lexicon.ecommerceplatform.repository.PromotionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository promotionRepository;

    /**
     * Returns all promotions whose date range includes today.
     */
    @Override
    public List<PromotionResponseDto> getActivePromotions() {
        LocalDate today = LocalDate.now();
        return promotionRepository.findAllActiveOn(today)
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    /**
     * Finds the best (highest-percentage) active promotion that applies to the
     * given product and returns the resulting discounted price.
     * Falls back to the product's original price when no promotion applies.
     */
    @Override
    public BigDecimal calculateDiscount(Product product) {
        LocalDate today = LocalDate.now();

        Optional<Promotion> bestPromotion = product.getPromotions()
                .stream()
                .filter(p -> !today.isBefore(p.getStartDate()) && !today.isAfter(p.getEndDate()))
                .max(Comparator.comparing(Promotion::getDiscountPercentage));

        if (bestPromotion.isEmpty()) {
            return product.getPrice();
        }

        BigDecimal discountPercentage = bestPromotion.get().getDiscountPercentage();
        BigDecimal discountMultiplier = BigDecimal.ONE
                .subtract(discountPercentage.divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP));

        return product.getPrice()
                .multiply(discountMultiplier)
                .setScale(2, RoundingMode.HALF_UP);
    }

    // -------------------------------------------------------------------------
    // Private helpers
    // -------------------------------------------------------------------------

    private PromotionResponseDto toResponseDto(Promotion promotion) {
        return PromotionResponseDto.builder()
                .id(promotion.getId())
                .code(promotion.getCode())
                .startDate(promotion.getStartDate())
                .endDate(promotion.getEndDate())
                .discountPercentage(promotion.getDiscountPercentage())
                .build();
    }
}
