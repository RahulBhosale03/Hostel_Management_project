package com.hostel.hostel_management.dto;

import com.hostel.hostel_management.enums.PaymentMode;

public class PaymentRequest {

    private Long bookingId;
    private Double amount;
    private PaymentMode mode;

    public PaymentRequest (){}

    public PaymentRequest(Long bookingId, Double amount, PaymentMode mode) {
        this.bookingId = bookingId;
        this.amount = amount;
        this.mode = mode;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PaymentMode getMode() {
        return mode;
    }

    public void setMode(PaymentMode mode) {
        this.mode = mode;
    }
}
