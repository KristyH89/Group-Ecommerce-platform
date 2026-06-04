package com.manjula.ecommerceplatform.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponseDto {



    private Long id;

    private String firstName;


    private String lastName;



    private String email;


    private Instant createdAt;

    // Address Details


    private String street;


    private String city;


    private String zipCode;

    // User Profile Details

    private String nickname;


    private String phoneNumber;



    private String bio;
}
