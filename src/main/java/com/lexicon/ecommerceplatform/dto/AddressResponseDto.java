package com.lexicon.ecommerceplatform.dto;

public record AddressResponseDto(
        Long id,
        String street,
        String city,
        String zipCode
) {
}
