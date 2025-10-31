package org.example.service;

import org.example.entity.Customers;
import org.example.entity.Enterprises;
import org.example.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    public Enterprises create(Enterprises enterprise) {
        return enterpriseRepository.save(enterprise);
    }

    public List<Enterprises> getAll(){
        return enterpriseRepository.findAll();
    }

    public Enterprises getByCnpj(String cnpj){
        return enterpriseRepository.findByCnpj(cnpj);
    }

    public void deleteById(Long id) {
        enterpriseRepository.deleteById(id);
    }

}
