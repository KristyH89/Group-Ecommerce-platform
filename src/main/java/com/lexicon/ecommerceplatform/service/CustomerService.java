package com.lexicon.ecommerceplatform.service;



import com.lexicon.ecommerceplatform.dto.CustomerRequestDto;
import com.lexicon.ecommerceplatform.dto.CustomerResponseDto;


public interface CustomerService {

    CustomerResponseDto register(CustomerRequestDto request);
    CustomerResponseDto findById(Long id);
    CustomerResponseDto update(Long id, CustomerRequestDto request);
}
