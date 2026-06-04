package com.lexicon.ecommerceplatform.service;



import com.lexicon.ecommerceplatform.dto.CustomerRequestDto;
import com.lexicon.ecommerceplatform.dto.CustomerResponseDto;

import java.util.List;

public interface CustomerService {

    // Create Customer
    CustomerResponseDto createCustomer(CustomerRequestDto dto);

    // Get All Customers
    List<CustomerResponseDto> getAllCustomers();

    // Get Customer By Email
    CustomerResponseDto getCustomerByEmail(String email);
}
