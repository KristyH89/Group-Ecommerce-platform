package com.lexicon.ecommerceplatform.dto;

import lombok.Data;

@Data
public class CustomerRequestDto {

    private String firstName;
    private String lastName;
    private String email;

    private String street;
    private String city;
    private String zipCode;

    private String nickname;
    private String phoneNumber;
    private String bio;
}
