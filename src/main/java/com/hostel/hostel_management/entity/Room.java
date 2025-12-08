package com.hostel.hostel_management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String roomNumber;
    private String pricePerMonth;
    private boolean available = true;

    @Column(length = 1000)
    private String description;

    //Default Constructor

    public Room (){}

    //Parameterized Constructor
    public Room(long id, String roomNumber, String pricePerMonth, boolean available, String description) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.pricePerMonth = pricePerMonth;
        this.available = available;
        this.description = description;
    }

    //Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(String pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
