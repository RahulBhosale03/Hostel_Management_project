package com.hostel.hostel_management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LoginRequest {

    @Email(message = "Invalid Email")
    @NotNull(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    //Default Constructor
    public LoginRequest(){}

    //Parameterized Constructor

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    //Getters and Setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
