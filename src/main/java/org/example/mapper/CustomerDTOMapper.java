package org.example.mapper;

import lombok.experimental.UtilityClass;
import org.example.dto.CustomerDTO;
import org.example.entity.Customers;

@UtilityClass
public class CustomerDTOMapper {

    // converter Customers -> CustomerDTO
    public CustomerDTO map(Customers customers) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customerDTO.getId());
        customerDTO.setName(customers.getName());
        customerDTO.setCpf(customers.getCpf());
        customerDTO.setTelephone(customers.getTelephone());

        return customerDTO;
    }

}
