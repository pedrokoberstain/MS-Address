package com.compassuol.challenge3.address.client;

import com.compassuol.challenge3.address.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br")
public interface ViaCepClient {

    @GetMapping("/{cep}/json/")
    Address getAddressByCep(@PathVariable("cep") String cep);
}
