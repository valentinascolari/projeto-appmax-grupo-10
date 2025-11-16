package org.example.mapper;

import lombok.experimental.UtilityClass;
import org.example.dto.EnterprisesDTO;
import org.example.entity.Enterprises;

@UtilityClass
public class EnterprisesMapper {

    public Enterprises map(EnterprisesDTO enterprisesDTO){
        return Enterprises
                .builder()
                .id(enterprisesDTO.getId())
                .name(enterprisesDTO.getName())
                .cnpj(enterprisesDTO.getCnpj())
                .telephone(enterprisesDTO.getTelephone())
                .email(enterprisesDTO.getEmail())
                .build();
    }

}
