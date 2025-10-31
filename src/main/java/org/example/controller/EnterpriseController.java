package org.example.controller;

import org.example.entity.Customers;
import org.example.entity.Enterprises;
import org.example.service.CustomerService;
import org.example.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enterprises")
public class EnterpriseController {
    //CRUD: create, read(listById, listAll), update, delete, insert

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping
    public ResponseEntity<List<Enterprises>> getAll() {
        List<Enterprises> customersList = enterpriseService.getAll();

        return ResponseEntity.ok(customersList);
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<Enterprises> getByCpf(@PathVariable String cnpj) {
        Enterprises enterprise = enterpriseService.getByCnpj(cnpj);

        return ResponseEntity.ok(enterprise);
    }

    @PostMapping //salvando a empresa
    public ResponseEntity<Enterprises> create(@RequestBody Enterprises enterprises) {
        Enterprises newEnterprises = enterpriseService.create(enterprises);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEnterprises);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        enterpriseService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
