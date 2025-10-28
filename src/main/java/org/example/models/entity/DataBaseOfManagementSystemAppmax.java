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
@Table(name = "transportadora")
@Data
@NoArgsConstructor

public class DataBaseOfManagementSystemAppmax {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome_cliente", nullable = false)
    private String nomeCliente;

    @Column(name = "cpf", unique = true, length = 11)
    private String cpf;

    @Column(name = "status_pedido")
    private String statusPedido;

    @Column(name = "codigo_rastreio", unique = true)
    private String codigoRastreio;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;
}
