package com.compassuol.challenge3.address.service;

import com.compassuol.challenge3.address.client.ViaCepClient;
import com.compassuol.challenge3.address.exception.CepNotFoundException;
import com.compassuol.challenge3.address.model.Address;
import com.compassuol.challenge3.address.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final ViaCepClient viaCepClient;
    private final AddressRepository addressRepository;

    public Address verifyAndStoreAddress(Long userId, String cep) {
        Address existingAddress = addressRepository.findByCep(cep);
        if (existingAddress != null) {
            return existingAddress;
        }

        Address address = viaCepClient.getAddressByCep(cep);

        if (address == null) {
            throw new CepNotFoundException("CEP not found: " + cep);
        }

        address.setUserId(userId);

        return addressRepository.save(address);
    }
}