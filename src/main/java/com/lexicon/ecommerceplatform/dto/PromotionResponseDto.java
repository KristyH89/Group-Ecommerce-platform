package com.lexicon.ecommerceplatform.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromotionResponseDto {

    private Long id;

    private String code;

    private LocalDate startDate;

    private LocalDate endDate;

    private BigDecimal discountPercentage;
}
