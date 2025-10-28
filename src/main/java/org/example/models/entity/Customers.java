package org.example.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "pedidos_clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_pedido", unique = true, nullable = false)
    private String idPedido;

    @Column(name = "nome_cliente", nullable = false)
    private String nomeCliente;

    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;

    @Column(name = "status_compra", nullable = false)
    private String statusCompra;

    @Column(name = "id_empresa", nullable = false)
    private Long idEmpresa;

    @Column(name = "valor_compra", precision = 10, scale = 2, nullable = false)
    private BigDecimal valorCompra;

    @Column(name = "site_compra")
    private String siteDaCompra;

    @Column(name = "codigo_rastreio", unique = true, nullable = false)
    private String codigoRastreio;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "forma_pagamento", nullable = false)
    private String formaPagamento;
}