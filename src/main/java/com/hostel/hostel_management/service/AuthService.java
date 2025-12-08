package com.hostel.hostel_management.service;

import com.hostel.hostel_management.dto.LoginRequest;
import com.hostel.hostel_management.dto.RegisterRequest;
import com.hostel.hostel_management.dto.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    UserResponse register(RegisterRequest request);

    String login(LoginRequest request);
}
