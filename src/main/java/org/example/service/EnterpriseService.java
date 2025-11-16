package org.example.service;

import jakarta.transaction.Transactional;
import org.example.dto.EnterprisesDTO;
import org.example.entity.Enterprises;
import org.example.mapper.EnterprisesDTOMapper;
import org.example.mapper.EnterprisesMapper;
import org.example.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Transactional
    public EnterprisesDTO create(EnterprisesDTO enterprisesDTO) {
        Enterprises enterprises = EnterprisesMapper.map(enterprisesDTO);

        Enterprises enterprises1 = enterpriseRepository.save(enterprises);

        return EnterprisesDTOMapper.map(enterprises1);
    }

    public List<EnterprisesDTO> getAll() {
        return enterpriseRepository
                .findAll()
                .stream()
                .map(EnterprisesDTOMapper::map)
                .collect(Collectors.toList());
    }

    public EnterprisesDTO getByCnpj(String cnpj) {
        Enterprises enterprises = enterpriseRepository.findByCnpj(cnpj);

        return EnterprisesDTOMapper.map(enterprises);
    }

    public EnterprisesDTO updateById(Integer id, EnterprisesDTO updatedEnterprise) {
        Enterprises existing = enterpriseRepository.findById(id);

        if (updatedEnterprise.getName() != null) {
            existing.setName(updatedEnterprise.getName());
        }

        if (updatedEnterprise.getEmail() != null) {
            existing.setEmail(updatedEnterprise.getEmail());
        }

        Enterprises enterprises = enterpriseRepository.save(existing);

        return EnterprisesDTOMapper.map(enterprises);
    }

    public void deleteById(Long id) {
        enterpriseRepository.deleteById(id);
    }

}
