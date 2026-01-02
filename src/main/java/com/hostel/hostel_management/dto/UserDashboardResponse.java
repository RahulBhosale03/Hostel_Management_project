package com.hostel.hostel_management.dto;

import com.hostel.hostel_management.enums.PaymentStatus;

import java.time.LocalDate;

public class UserDashboardResponse {

    private String roomNumber;
    private String roomType;

    private boolean bookingActive;
    private PaymentStatus paymentStatus;
    private LocalDate rentDueDate;

    private long totalComplaints;
    private long openComplaints;

    public UserDashboardResponse() {}

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isBookingActive() {
        return bookingActive;
    }

    public void setBookingActive(boolean bookingActive) {
        this.bookingActive = bookingActive;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDate getRentDueDate() {
        return rentDueDate;
    }

    public void setRentDueDate(LocalDate rentDueDate) {
        this.rentDueDate = rentDueDate;
    }

    public long getTotalComplaints() {
        return totalComplaints;
    }

    public void setTotalComplaints(long totalComplaints) {
        this.totalComplaints = totalComplaints;
    }

    public long getOpenComplaints() {
        return openComplaints;
    }

    public void setOpenComplaints(long openComplaints) {
        this.openComplaints = openComplaints;
    }
}
