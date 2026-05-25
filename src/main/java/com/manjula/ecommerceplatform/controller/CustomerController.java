package com.manjula.ecommerceplatform.controller;

import com.manjula.ecommerceplatform.dto.CustomerRequestDto;
import com.manjula.ecommerceplatform.dto.CustomerResponseDto;
import com.manjula.ecommerceplatform.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    // CREATE CUSTOMER
    @PostMapping
    public CustomerResponseDto createCustomer(
            @RequestBody CustomerRequestDto dto
    ) {

        return customerService.createCustomer(dto);
    }

    // GET ALL CUSTOMERS
    @GetMapping
    public List<CustomerResponseDto> getAllCustomers() {

        return customerService.getAllCustomers();
    }

    // GET CUSTOMER BY EMAIL
    @GetMapping("/{email}")
    public CustomerResponseDto getCustomerByEmail(
            @PathVariable String email
    ) {

        return customerService.getCustomerByEmail(email);
    }
}