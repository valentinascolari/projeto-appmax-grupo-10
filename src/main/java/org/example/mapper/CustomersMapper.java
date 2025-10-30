package org.example.mapper;

import lombok.experimental.UtilityClass;
import org.example.dto.CustomerDTO;
import org.example.entity.Customers;

@UtilityClass
public class CustomersMapper {

    // converte CustomerDTO -> Customers
    public Customers map(CustomerDTO customerDTO) {
        return Customers.builder()
                .id(customerDTO.getId())
                .name(customerDTO.getName())
                .cpf(customerDTO.getCpf())
                .telephone(customerDTO.getTelephone())
                .email(customerDTO.getEmail())
                .build();
    }

}
