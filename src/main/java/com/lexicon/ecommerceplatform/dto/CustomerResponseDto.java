package com.lexicon.ecommerceplatform.dto;

public record CustomerResponseDto(
        Long id,
        String fullName,
        String email,
        AddressResponseDto addressResponse
) {
}
