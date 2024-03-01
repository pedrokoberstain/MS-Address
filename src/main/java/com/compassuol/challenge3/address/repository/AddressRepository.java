package com.compassuol.challenge3.address.repository;

import com.compassuol.challenge3.address.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findByCep(String cep);
}
