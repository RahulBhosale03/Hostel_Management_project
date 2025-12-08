package com.hostel.hostel_management.dto;

public class ComplaintRequest {

    private String message;
    private String category;

    public ComplaintRequest(){}

    public ComplaintRequest(String message, String category) {
        this.message = message;
        this.category = category;
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
}
