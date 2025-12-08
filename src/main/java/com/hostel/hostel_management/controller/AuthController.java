package com.hostel.hostel_management.controller;

import com.hostel.hostel_management.dto.LoginRequest;
import com.hostel.hostel_management.dto.RegisterRequest;
import com.hostel.hostel_management.dto.UserResponse;
import com.hostel.hostel_management.entity.User;
import com.hostel.hostel_management.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    private final AuthService authService;


    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest request){
        UserResponse response = authService.register(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        String token = authService.login(request);
        return ResponseEntity.ok(
                java.util.Map.of("token",token)
        );
    }
}
