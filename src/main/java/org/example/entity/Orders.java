package org.example.entity;

import jakarta.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.example.enumerator.PaymentMethodEnum;
import org.example.enumerator.PurchaseStatusEnum;

import java.math.BigDecimal;

@Entity
@Table(name = "ORDERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_CUSTOMER", unique = true, nullable = false)
    private Long idCustomer;

    @Enumerated(EnumType.STRING)
    @Column(name = "PURCHASE_STATUS", nullable = false)
    private PurchaseStatusEnum purchaseStatus;

    @Column(name = "PURCHASE_VALUE", precision = 10, scale = 2, nullable = false)
    private BigDecimal purchaseValue;

    @Column(name = "PURCHASE_WEBSITE")
    private String purchaseWebsite;

    @Column(name = "TRACKING_CODE", nullable = false)
    private String trackingCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "PAYMENT_METHOD", nullable = false)
    private PaymentMethodEnum paymentMethod;

    @Column(name = "ID_ENTERPRISE", nullable = false)
    private Long idEnterprise;

}
