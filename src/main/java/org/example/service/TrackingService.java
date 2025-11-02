package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.client.carrier.CarrierClient;
import org.example.client.carrier.response.TrackingResponse;
import org.example.client.mail.MailClient;
import org.example.client.mail.response.LocationResponse;
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

    @Scheduled(fixedRate = 100000) // cronograma p fazer a requisição a cada N milissegundos
    public void consultarCodigoRatreio() {
        // 1- pega os pedidos e cria uma lista
        List<Orders> ordersList = ordersRepository.findAll(); //busca todas as orders do banco e coloca numa lista

        // para cada pedido:
        // 1 - pega o id do cliente
        // 2 - se existir pega o cliente
        // 3 - depois de pegar o cliente, pega o cpf do cliente

        for (Orders order : ordersList) // for each
        {
            Long idCustomer = order.getIdCustomer();


            //já estava na biblioteca CrudRepository
            Optional<Customers> customer = customerRepository.findById(idCustomer); // generics Obj<Classe>var
            if (customer.isPresent()) {
                Customers customers = customer.get();
                String cpf = customers.getCpf();

                // 1- Passar o cpf para transportadora e retornar o codigo de rastreio
                TrackingResponse trackingResponse = carrierClient.askCodeCpfCustomer(cpf);
                List<String> codeList = trackingResponse.getTrackingCode();

                for (String code : codeList) { //para cada codigo, ele esta indo no codeList da transportadora -57

                    // 2 - Passar o codigo de rastreio para os correios e retornar a última posição
                    LocationResponse locationResponse = mailClient.askLocationCode(code);
                    String city = locationResponse.getCity();

                    // 3 - Chamar o whatsapp
                    String telefone = customer.get().getTelephone();
                    log.info("Telefone: " + telefone + "Cidade: " + city);
                }
            }
        }
    }
}
