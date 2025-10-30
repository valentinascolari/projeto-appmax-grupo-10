package org.example.client.carrier;

import org.example.client.carrier.response.Tracking;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CarrierClient", url = "https://example.free.beeceptor.com")
public interface CarrierClient {

    @GetMapping("/clientes/{cpf}")
    Tracking askCodeCpfCustomer(@PathVariable("cpf") String cpf);
}