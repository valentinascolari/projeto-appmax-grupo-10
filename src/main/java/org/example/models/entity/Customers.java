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
@Table(name = "PEDIDOS_CLIENTES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_PEDIDO", unique = true, nullable = false)
    private String idOrder;

    @Column(name = "NOME_CLIENTE", nullable = false)
    private String nameCustomers;

    @Column(name = "CPF", length = 11, nullable = false)
    private String cpf;

    @Column(name = "STATUS_COMPRA", nullable = false)
    private String purchaseStatus;

    @Column(name = "ID_EMPRESA", nullable = false)
    private Long idEnterprise;

    @Column(name = "VALOR_COMPRA", precision = 10, scale = 2, nullable = false)
    private BigDecimal purchaseValue;

    @Column(name = "SITE_COMPRA")
    private String purchaseWebsite;

    @Column(name = "CODIGO_RASTREIO", unique = true, nullable = false)
    private String trackingCode;

    @Column(name = "TELEFONE")
    private String telephone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "FORMA_PAGAMENTO", nullable = false)
    private String paymentMethod;
}