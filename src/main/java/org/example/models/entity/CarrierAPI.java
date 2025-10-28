package org.example.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TRANSPORTADORA")
@Data
@NoArgsConstructor
public class CarrierAPI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "NOME_CLIENTE", nullable = false)
    private String nameCustomer;

    @Column(name = "CPF", unique = true, length = 11)
    private String cpf;

    @Column(name = "STATUS_PEDIDO")
    private String orderStatus;

    @Column(name = "CODIGO_RASTREIO", unique = true)
    private String trackingCode;

    @Column(name = "ENDERECO")
    private String adress;

    @Column(name = "email")
    private String email;

    @Column(name = "TELEFONE")
    private String telephone;
}