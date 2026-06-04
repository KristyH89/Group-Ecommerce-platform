package com.manjula.ecommerceplatform.service;



import com.manjula.ecommerceplatform.dto.request.CustomerRequest;
import com.manjula.ecommerceplatform.dto.response.CustomerResponse;


public interface CustomerService {

    CustomerResponse register(CustomerRequest request);
    CustomerResponse findById(Long id);
    CustomerResponse update(Long id, CustomerRequest request);
}
