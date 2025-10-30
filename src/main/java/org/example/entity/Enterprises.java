package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ENTERPRISES")
@Getter
@Setter
public class Enterprises {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //criar um valor de ID
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CNPJ")
    private String cnpj;

    @Column(name = "TELEPHONE")
    private String telephone;

    @Column(name = "EMAIL")
    private String email;

}
