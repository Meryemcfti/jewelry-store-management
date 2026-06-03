package org.example.jewelrystoremanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PaymentRequest {

    @NotNull(message = "Müşteri id boş bırakılamaz.")
    private Long customerId;

    @NotNull(message = "Ürün id boş bırakılamaz.")
    private Long productId;

    @NotNull(message = "Ödeme tutarı boş bırakılamaz.")
    @Positive(message = "Ödeme tutarı 0'dan büyük olmalıdır.")
    private Double amount;

    @NotBlank(message = "Ödeme yöntemi boş bırakılamaz.")
    private String paymentMethod;

    public PaymentRequest() {
    }

    public PaymentRequest(Long customerId, Long productId, Double amount, String paymentMethod) {
        this.customerId = customerId;
        this.productId = productId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
