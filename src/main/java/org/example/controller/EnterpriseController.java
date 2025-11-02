package org.example.controller;

import org.example.dto.EnterprisesDTO;
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

    @PostMapping //salvando a empresa
    public ResponseEntity<EnterprisesDTO> create(@RequestBody EnterprisesDTO enterprisesDTO) {
        EnterprisesDTO newEnterprisesDTO = enterpriseService.create(enterprisesDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEnterprisesDTO);
    }

    @GetMapping
    public ResponseEntity<List<EnterprisesDTO>> getAll() {
        List<EnterprisesDTO> customersList = enterpriseService.getAll();

        return ResponseEntity.ok(customersList);
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<EnterprisesDTO> getByCpf(@PathVariable String cnpj) {
        EnterprisesDTO enterprisesDTO = enterpriseService.getByCnpj(cnpj);

        return ResponseEntity.ok(enterprisesDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnterprisesDTO> updateById(@PathVariable Integer id, @RequestBody EnterprisesDTO enterprisesDTO) {
        EnterprisesDTO updatedEnterprise = enterpriseService.updateById(id, enterprisesDTO);

        return ResponseEntity.ok(updatedEnterprise);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        enterpriseService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
