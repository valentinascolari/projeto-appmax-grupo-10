package org.example.client.whatsapp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

// Define que este cliente vai conectar na URL onde seu Docker do EvolutionAPI está rodando
@FeignClient(name = "WhatsappClient", url = "http://localhost:8080") 
public interface WhatsappClient {

    // Mapeia o endpoint de envio de texto da EvolutionAPI
    // 'appmax-bot' é o nome da instância que vimos na sua imagem do painel
    @PostMapping("/message/sendText/appmax-bot") 
    void sendMessage(
            @RequestHeader("apikey") String apiKey, 
            @RequestBody WhatsappRequest request
    );
}