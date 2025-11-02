package org.example.controller;

import java.util.List;

import org.example.entity.Customers;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    //CRUD: create, read(listById, listAll), update, delete, insert

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customers>> getAll() {
        List<Customers> customersList = customerService.getAll();

        return ResponseEntity.ok(customersList); // ok: status code
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Customers> getByCpf(@PathVariable String cpf) {
        Customers customer = customerService.getByCpf(cpf);

        return ResponseEntity.ok(customer); // ok: status code
    }

    @PostMapping //salvando o customer
    public ResponseEntity<Customers> create(@RequestBody Customers customers) {
        Customers newCustomer = customerService.create(customers);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        customerService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}