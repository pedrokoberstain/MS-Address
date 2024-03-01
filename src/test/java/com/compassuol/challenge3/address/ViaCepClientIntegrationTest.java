package com.compassuol.challenge3.address;

import com.compassuol.challenge3.address.client.ViaCepClient;
import com.compassuol.challenge3.address.model.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ViaCepClientIntegrationTest {
    @Autowired
    private ViaCepClient viaCepClient;

    @Test
    public void testGetAddressByCep() {
        String cep = "05425-070";
        Address address = viaCepClient.getAddressByCep(cep);

        assert address != null;

        System.out.println("Endereço retornado: " + address);

    }

}
