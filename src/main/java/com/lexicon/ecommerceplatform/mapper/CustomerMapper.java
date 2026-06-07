package com.lexicon.ecommerceplatform.mapper;

import com.lexicon.ecommerceplatform.dto.CustomerRequestDto;
import com.lexicon.ecommerceplatform.dto.AddressResponseDto;
import com.lexicon.ecommerceplatform.dto.CustomerResponseDto;
import com.lexicon.ecommerceplatform.entity.Address;
import com.lexicon.ecommerceplatform.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerResponseDto toResponse(Customer customer) {

        AddressResponseDto addressResponse = null;

        if (customer.getAddress() != null) {
            addressResponse = new AddressResponseDto(
                    customer.getAddress().getId(),
                    customer.getAddress().getStreet(),
                    customer.getAddress().getCity(),
                    customer.getAddress().getZipCode()
            );
        }

        return new CustomerResponseDto(
                customer.getId(),
                customer.getFirstName() + " " + customer.getLastName(),
                customer.getEmail(),
                addressResponse
        );
    }

    public Customer toEntity(CustomerRequestDto request) {

        Address address = new Address();
        address.setStreet(request.street());
        address.setCity(request.city());
        address.setZipCode(request.zipCode());

        Customer customer = new Customer();
        customer.setFirstName(request.firstName());
        customer.setLastName(request.lastName());
        customer.setEmail(request.email());
        customer.setAddress(address);

        return customer;
    }
}
