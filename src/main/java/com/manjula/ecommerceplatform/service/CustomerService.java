package com.manjula.ecommerceplatform.service;



import com.manjula.ecommerceplatform.dto.CustomerRequestDto;
import com.manjula.ecommerceplatform.dto.CustomerResponseDto;

import java.util.List;

public interface CustomerService {

    // Create Customer
    CustomerResponseDto createCustomer(CustomerRequestDto dto);

    // Get All Customers
    List<CustomerResponseDto> getAllCustomers();

    // Get Customer By Email
    CustomerResponseDto getCustomerByEmail(String email);
}
