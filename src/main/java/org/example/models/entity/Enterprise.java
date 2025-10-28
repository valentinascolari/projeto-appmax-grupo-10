package org.example.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "EMPRESA")
@Getter
@Setter
public class Enterprise {

    @Column(name = "NOME_DA_EMPRESA")
    private String name;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "CNPJ")
    private String cnpj;

    @Column(name = "TELEFONE")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

}
