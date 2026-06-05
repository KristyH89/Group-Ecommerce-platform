package com.lexicon.ecommerceplatform.service;

import com.lexicon.ecommerceplatform.dto.request.CustomerRequest;
import com.lexicon.ecommerceplatform.dto.response.CustomerResponse;
import com.lexicon.ecommerceplatform.entity.Customer;
import com.lexicon.ecommerceplatform.exception.EmailAlreadyExistsException;
import com.lexicon.ecommerceplatform.exception.ResourceNotFoundException;
import com.lexicon.ecommerceplatform.mapper.CustomerMapper;
import com.lexicon.ecommerceplatform.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import com.lexicon.ecommerceplatform.entity.Address;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(
            CustomerRepository customerRepository,
            CustomerMapper customerMapper) {

        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponse register(CustomerRequest request) {

        if (customerRepository.existsByEmail(request.email())) {

            throw new EmailAlreadyExistsException(
                    "Email already exists: " + request.email()
            );
        }

        Customer customer = customerMapper.toEntity(request);

        Customer savedCustomer =
                customerRepository.save(customer);

        return customerMapper.toResponse(savedCustomer);
    }

    @Override
    public CustomerResponse findById(Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found with id: " + id));

        return customerMapper.toResponse(customer);
    }

    @Override
    public CustomerResponse update(Long id, CustomerRequest request) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found with id: " + id));

        customer.setFirstName(request.firstName());
        customer.setLastName(request.lastName());
        customer.setEmail(request.email());
        Address address = customer.getAddress();

        if (address == null) {
            address = new Address();
        }

        address.setStreet(request.street());
        address.setCity(request.city());
        address.setZipCode(request.zipCode());

        customer.setAddress(address);

        Customer updatedCustomer =
                customerRepository.save(customer);

        return customerMapper.toResponse(updatedCustomer);
    }
}