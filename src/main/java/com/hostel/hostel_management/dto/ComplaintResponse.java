package com.hostel.hostel_management.dto;

public class ComplaintResponse {

    private Long id;
    private Long userId;
    private String message;
    private String category;
    private Boolean resolved;


    public ComplaintResponse(){}

    public ComplaintResponse(Long id, Long userId, String message,
                             String category, Boolean resolved) {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.category = category;
        this.resolved = resolved;
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

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }
}
