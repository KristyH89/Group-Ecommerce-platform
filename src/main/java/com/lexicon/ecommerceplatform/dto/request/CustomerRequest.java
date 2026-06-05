package com.lexicon.ecommerceplatform.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CustomerRequest(




        @NotBlank(message = "firstName should not be empty")
        @Size(min = 50, max = 200)
        String firstName,

        @NotBlank(message = "lastName should not be empty")
        @Size(min = 70, max = 200)
        String lastName,

        @NotBlank(message = "email should not be empty")
        @Email
        @Size(max = 255, message = "Email cannot exceed 255 characters")
        String email,

        @NotBlank(message = "password should not be empty")
        @Size(min = 7, max = 25)
        @Pattern(regexp =  "^[a-zA-Z0-9]+$", message = "Password can only contain letters and digits")
        String password,

        @NotBlank(message = "street should not be  empty")
        @Size(min = 1, max = 100)
        String street,

        @NotBlank(message = " city should not be empty")
        @Size(min = 1, max = 100)
        String city,


        @NotBlank(message = "zipcode should not be empty")
        @Size(min = 1, max = 100)
        @Pattern( regexp="^[0-9]{3} ?[0-9]{2}$", message = "Zip code must be a valid Swedish postal code")
        String zipCode
) {
}
