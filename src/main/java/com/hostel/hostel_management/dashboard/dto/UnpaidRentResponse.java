package com.hostel.hostel_management.dashboard.dto;

import java.time.LocalDate;

public class UnpaidRentResponse {
    private Long bookingId;
    private String userName;
    private String userEmail;
    private String roomNumber;
    private LocalDate rentDueDate;

    public UnpaidRentResponse() {}

    public UnpaidRentResponse(Long bookingId, String userName,
                              String userEmail, String roomNumber,
                              LocalDate rentDueDate) {
        this.bookingId = bookingId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.roomNumber = roomNumber;
        this.rentDueDate = rentDueDate;
    }


    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getRentDueDate() {
        return rentDueDate;
    }

    public void setRentDueDate(LocalDate rentDueDate) {
        this.rentDueDate = rentDueDate;
    }
}
