package com.hostel.hostel_management.dto;

import com.hostel.hostel_management.enums.TicketStatus;

import java.time.LocalDateTime;

public class ComplaintResponse {

    private Long id;
    private Long userId;
    private String message;
    private String category;
    private TicketStatus status;
    private LocalDateTime createdAt;


    public ComplaintResponse(){}

    public ComplaintResponse(Long id,
                             Long userId,
                             String message,
                             String category,
                             TicketStatus status,
                             LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.category = category;
        this.status = status;
        this.createdAt = createdAt;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
