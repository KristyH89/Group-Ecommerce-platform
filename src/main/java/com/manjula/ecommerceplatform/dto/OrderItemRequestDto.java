package com.manjula.ecommerceplatform.dto;

<<<<<<< HEAD
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
=======
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
>>>>>>> origin/feature/jpa-part3
import lombok.Data;
@Data
public class OrderItemRequestDto {

<<<<<<< HEAD
    @NotBlank(message = "productId ca not be empty")
    @Size(min = 1, max = 100)
    private Long productId;

    @NotBlank(message = "quantity can  not be empty")
    @Size(min = 1, max = 100)
=======
    @NotNull
    private Long productId;

    @Min(1)
>>>>>>> origin/feature/jpa-part3
    private Integer quantity;
}