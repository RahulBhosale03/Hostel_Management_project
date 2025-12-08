package com.hostel.hostel_management.dto;

import com.hostel.hostel_management.enums.PaymentMode;
import com.hostel.hostel_management.enums.PaymentStatus;

public class PaymentResponse {

    private Long id;
    private Double amount;
    private PaymentStatus status;
    private PaymentMode mode;
    private String transactionId;


    public PaymentResponse(){}

    public PaymentResponse(Long id, Double amount, PaymentStatus status,
                           PaymentMode mode, String transactionId) {
        this.id = id;
        this.amount = amount;
        this.status = status;
        this.mode = mode;
        this.transactionId = transactionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public PaymentMode getMode() {
        return mode;
    }

    public void setMode(PaymentMode mode) {
        this.mode = mode;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
