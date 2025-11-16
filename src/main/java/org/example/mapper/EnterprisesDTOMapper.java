package org.example.mapper;

import lombok.experimental.UtilityClass;
import org.example.dto.EnterprisesDTO;
import org.example.entity.Enterprises;

@UtilityClass
public class EnterprisesDTOMapper {

    public EnterprisesDTO map(Enterprises enterprises) {
        return EnterprisesDTO
                .builder()
                .id(enterprises.getId())
                .name(enterprises.getName())
                .cnpj(enterprises.getCnpj())
                .telephone(enterprises.getTelephone())
                .email(enterprises.getEmail())
                .build();
    }

}
