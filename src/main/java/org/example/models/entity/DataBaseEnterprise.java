package org.example.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Empresa")
@Getter
@Setter
public class DataBaseEnterprise {

    @Column(name = "nome da empresa")
    private String name;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "CNPJ")
    private String cnpj;

    @Column(name = "Telefone")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

}
