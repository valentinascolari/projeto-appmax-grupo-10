package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // toString, getter e setter,
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnterprisesDTO {

    private Long id;
    private String name;
    private String cnpj;
    private String telephone;
    private String email;

}
