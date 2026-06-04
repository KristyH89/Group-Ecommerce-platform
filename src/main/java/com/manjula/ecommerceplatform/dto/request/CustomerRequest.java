package com.manjula.ecommerceplatform.dto.request;

public record CustomerRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        String street,
        String city,
        String zipCode
) {
}
