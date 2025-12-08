package com.hostel.hostel_management.dto;

import com.hostel.hostel_management.entity.User;
import com.hostel.hostel_management.enums.RoleType;

public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private RoleType roleType;


    //Default Constructor
    public UserResponse(){}

    //Parameterized Constructor
    public UserResponse(Long id, String name, String email, RoleType roleType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.roleType = roleType;
    }

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
}
