package com.lexicon.ecommerceplatform.dto.response;

public record CustomerResponse(
        Long id,
        String fullName,
        String email,
        AddressResponse addressResponse
) {
}
