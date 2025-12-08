package com.hostel.hostel_management.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "complaints")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(length = 2000)
    private String message;

    private String category;

    private LocalDateTime createdAt = LocalDateTime.now();

    private boolean resolved = false;

    private String resolutionNote;

    //Default Constructor
    public Complaint(){}

    //Parameterized Constructo


    public Complaint(long id, User user, String message, String category,
                     LocalDateTime createdAt,boolean resolved,
                     String resolutionNote) {
        this.id = id;
        this.user = user;
        this.message = message;
        this.category = category;
        this.createdAt = createdAt;
        this.resolved = resolved;
        this.resolutionNote = resolutionNote;
    }

    //Getters and Setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    public String getResolutionNote() {
        return resolutionNote;
    }

    public void setResolutionNote(String resolutionNote) {
        this.resolutionNote = resolutionNote;
    }
}
