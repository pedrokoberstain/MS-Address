package com.compassuol.challenge3.address.controller;

import com.compassuol.challenge3.address.model.Address;
import com.compassuol.challenge3.address.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/verify-and-store")
    public Address verifyAndStoreAddress(@RequestParam("userId") Long userId, @RequestParam("cep") String cep) {
        return addressService.verifyAndStoreAddress(userId, cep);
    }
}