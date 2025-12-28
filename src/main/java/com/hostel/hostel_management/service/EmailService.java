package com.hostel.hostel_management.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface EmailService {

    void sendRendReminder(String email, String userName, LocalDate endDate);
}
