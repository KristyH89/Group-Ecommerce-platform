package com.lexicon.ecommerceplatform.service;

import com.lexicon.ecommerceplatform.dto.CustomerRequestDto;
import com.lexicon.ecommerceplatform.dto.CustomerResponseDto;
import com.lexicon.ecommerceplatform.entity.Customer;
import com.lexicon.ecommerceplatform.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.lexicon.ecommerceplatform.entity.Address;
import com.lexicon.ecommerceplatform.entity.UserProfile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponseDto createCustomer(CustomerRequestDto dto) {

        // Check if email already exists
        if (customerRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // Create Address object
        Address address = Address.builder()
                .street(dto.getStreet())
                .city(dto.getCity())
                .zipCode(dto.getZipCode())
                .build();

        // Create UserProfile object (optional)
        UserProfile profile = null;

        if (dto.getNickname() != null && !dto.getNickname().isBlank()) {

            profile = UserProfile.builder()
                    .nickname(dto.getNickname())
                    .phoneNumber(dto.getPhoneNumber())
                    .bio(dto.getBio())
                    .build();
        }

        // Create Customer object
        Customer customer = Customer.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .address(address)
                .profile(profile)
                .build();

        // Save customer
        Customer savedCustomer = customerRepository.save(customer);

        // Return response dto
        return mapToResponse(savedCustomer);
    }
    // GET ALL CUSTOMERS
    @Override
    public List<CustomerResponseDto> getAllCustomers() {

        return customerRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // GET CUSTOMER BY EMAIL
    @Override
    public CustomerResponseDto getCustomerByEmail(String email) {

        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return mapToResponse(customer);
    }

    // WRITE THE MAPPER METHOD HERE
    private CustomerResponseDto mapToResponse(Customer customer) {

        return CustomerResponseDto.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .createdAt(customer.getCreatedAt())

                .street(customer.getAddress().getStreet())
                .city(customer.getAddress().getCity())
                .zipCode(customer.getAddress().getZipCode())

                .nickname(
                        customer.getProfile() != null
                                ? customer.getProfile().getNickname()
                                : null
                )
                .phoneNumber(
                        customer.getProfile() != null
                                ? customer.getProfile().getPhoneNumber()
                                : null
                )
                .bio(
                        customer.getProfile() != null
                                ? customer.getProfile().getBio()
                                : null
                )
                .build();
    }
}