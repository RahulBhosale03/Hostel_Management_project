package com.hostel.hostel_management.exceptions;

import java.time.LocalDateTime;

public class ApiException {

    private String message;
    private LocalDateTime localDateTime;
    private int status;

    public ApiException(){}

    public ApiException(String message, LocalDateTime localDateTime, int status) {
        this.message = message;
        this.localDateTime = localDateTime;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
