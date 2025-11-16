package org.example.client.mail;

import org.example.client.mail.response.LocationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MailClient", url = "https://example.free.beeceptor.com")
public interface MailClient {

    @GetMapping("/orders/{code}")
    LocationResponse askLocationCode(@PathVariable("code") String code);

}
