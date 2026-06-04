package com.manjula.ecommerceplatform.dto;

import com.manjula.ecommerceplatform.dto.OrderItemResponseDto;
import com.manjula.ecommerceplatform.enums.OrderStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Instantiator;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class OrderResponseDto {



    private Long orderId;


    private Instant orderDate;



    private OrderStatus status;


    private Long customerId;


    private List<OrderItemResponseDto> items;
}