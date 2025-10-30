package org.example.service;

import org.example.entity.Customers;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customers> getAll(){
        return customerRepository.findAll();
    }

    public Customers getByCpf(String cpf) {
        return customerRepository.findByCpf(cpf);
    }

    public Customers create(Customers customers) {
        return customerRepository.save(customers);
    }

}
