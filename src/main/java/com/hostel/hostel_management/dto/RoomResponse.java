package com.hostel.hostel_management.dto;

public class RoomResponse {

    private Long id;
    private String roomNumber;
    private String type;
    private Double pricePerMonth;
    private Boolean available;
    private String description;

    public RoomResponse(){}

    public RoomResponse(Long id, String roomNumber, String type,
                        Double pricePerMonth, Boolean available,
                        String description) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerMonth = pricePerMonth;
        this.available = available;
        this.description = description;
    }

    public RoomResponse(long id, String roomNumber, String pricePerMonth, boolean available, String description) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(Double pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
