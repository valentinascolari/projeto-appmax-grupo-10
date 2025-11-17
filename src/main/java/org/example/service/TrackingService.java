package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.client.carrier.CarrierClient;
import org.example.client.mail.MailClient;
import org.example.client.whatsapp.WhatsappClient;
import org.example.client.whatsapp.WhatsappRequest;
import org.example.entity.Customers;
import org.example.entity.Orders;
import org.example.repository.CustomerRepository;
import org.example.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j //pra conseguir colocar log
@Service
public class TrackingService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired //injeção de dependencia automatica (substitui o = new...)
    private CarrierClient carrierClient;

    @Autowired
    private MailClient mailClient;

    @Autowired
    private WhatsappClient whatsappClient;

    // Deixei em 60 segundos para o teste rápido
    @Scheduled(fixedRate = 60000)
    public void consultarCodigoRatreio() {
        // 1- pega os pedidos e cria uma lista
        List<Orders> ordersList = ordersRepository.findAll(); //busca todas as orders do banco e coloca numa lista

        // para cada pedido:
        for (Orders order : ordersList) {
            Long idCustomer = order.getIdCustomer();

            Optional<Customers> customerOpt = customerRepository.findById(idCustomer);

            if (customerOpt.isPresent()) {
                Customers customers = customerOpt.get();
                String telephone = customers.getTelephone();
                String cpf = customers.getCpf();

                // Usar quando disponibilizarem a API da transportadora
                // TrackingResponse trackingResponse = carrierClient.askCodeCpfCustomer(cpf);

                // Vamos fingir que ele nos deu um código de rastreio:
                List<String> statusList = List.of(
                        "Olá! Seu pedido de XXXXXXXX da loja XXXXX foi confirmado. Para acompanhar seu pedido, o código de rastreio é: " + order.getTrackingCode(),
                        "Olá! Seu pedido de XXXXXXXX foi enviado.",
                        "Olá! Seu pedido de XXXXXXXX foi entregue. Até a próxima!");

                if (statusList != null) {

                    for (String status : statusList) {

                        try {
                            // Cria o objeto da requisição
                            WhatsappRequest request = WhatsappRequest.builder()
                                    .number(telephone)
                                    .text(status)
                                    .build();

                            // Envia a mensagem usando a API Key configurada no seu docker-compose (appmax123)
                            whatsappClient.sendMessage("appmax123", request);

                            log.info("Mensagem enviada com sucesso para: " + request.getNumber() + ", mensagem: " + request.getText());

                        } catch (Exception e) {
                            log.error("Falha ao enviar WhatsApp para " + e.getMessage());
                        }
                    }
                }
            }
        }
    }
}