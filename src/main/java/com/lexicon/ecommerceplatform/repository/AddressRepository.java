package com.lexicon.ecommerceplatform.repository;



import com.lexicon.ecommerceplatform.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByZipCode(String zipCode);

    List<Address> findByCity(String city);

    List<Address> findByStreetContaining(String street);

    List<Address> findByZipCodeStartingWith(String prefix);
}
