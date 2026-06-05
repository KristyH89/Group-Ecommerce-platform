package com.lexicon.ecommerceplatform.service;



import com.lexicon.ecommerceplatform.dto.request.CustomerRequest;
import com.lexicon.ecommerceplatform.dto.response.CustomerResponse;


public interface CustomerService {

    CustomerResponse register(CustomerRequest request);
    CustomerResponse findById(Long id);
    CustomerResponse update(Long id, CustomerRequest request);
}
