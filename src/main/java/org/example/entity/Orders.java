package org.example.entity;

import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.example.enumerator.PaymentMethod;
import org.example.enumerator.PurchaseStatus;

import java.math.BigDecimal;

@Entity
@Table(name = "ORDERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_CUSTOMER", unique = true, nullable = false)
    private Long idCustomer;

    @Enumerated(EnumType.STRING)
    @Column(name = "PURCHASE_STATUS", nullable = false)
    private PurchaseStatus purchaseStatus;

    @Column(name = "PURCHASE_VALUE", precision = 10, scale = 2, nullable = false)
    private BigDecimal purchaseValue;

    @Column(name = "PURCHASE_WEBSITE")
    private String purchaseWebsite;

    @Column(name = "TRACKING_CODE", nullable = false)
    private String trackingCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "PAYMENT_METHOD", nullable = false)
    private PaymentMethod paymentMethod;

    @Column(name = "ID_ENTERPRISE", nullable = false)
    private Long idEnterprise;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public PurchaseStatus getPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchaseStatus(PurchaseStatus purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }

    public BigDecimal getPurchaseValue() {
        return purchaseValue;
    }

    public void setPurchaseValue(BigDecimal purchaseValue) {
        this.purchaseValue = purchaseValue;
    }

    public String getPurchaseWebsite() {
        return purchaseWebsite;
    }

    public void setPurchaseWebsite(String purchaseWebsite) {
        this.purchaseWebsite = purchaseWebsite;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Long getIdEnterprise() {
        return idEnterprise;
    }

    public void setIdEnterprise(Long idEnterprise) {
        this.idEnterprise = idEnterprise;
    }
}
