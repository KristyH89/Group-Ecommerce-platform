package com.manjula.ecommerceplatform.mapper;

import com.manjula.ecommerceplatform.dto.request.CustomerRequest;
import com.manjula.ecommerceplatform.dto.response.AddressResponse;
import com.manjula.ecommerceplatform.dto.response.CustomerResponse;
import com.manjula.ecommerceplatform.entity.Address;
import com.manjula.ecommerceplatform.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerResponse toResponse(Customer customer) {

        AddressResponse addressResponse = null;

        if (customer.getAddress() != null) {
            addressResponse = new AddressResponse(
                    customer.getAddress().getId(),
                    customer.getAddress().getStreet(),
                    customer.getAddress().getCity(),
                    customer.getAddress().getZipCode()
            );
        }

        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName() + " " + customer.getLastName(),
                customer.getEmail(),
                addressResponse
        );
    }

    public Customer toEntity(CustomerRequest request) {

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
