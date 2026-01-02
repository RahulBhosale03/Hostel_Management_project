package com.hostel.hostel_management.serviceImpl;

import com.hostel.hostel_management.config.JwtUtil;
import com.hostel.hostel_management.dto.LoginRequest;
import com.hostel.hostel_management.dto.RegisterRequest;
import com.hostel.hostel_management.dto.UserResponse;
import com.hostel.hostel_management.entity.User;
import com.hostel.hostel_management.enums.RoleType;
import com.hostel.hostel_management.repository.UserRepository;
import com.hostel.hostel_management.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(
            UserRepository userRepo,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            JwtUtil jwtUtil
    ) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    // ✅ REGISTER (NO CHANGE)
    @Override
    public UserResponse register(RegisterRequest request) {

        if (userRepo.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exist");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(RoleType.USER);

        User saved = userRepo.save(user);

        return new UserResponse(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getRole()
        );
    }

    // ✅ LOGIN (FIXED)
    @Override
    public String login(LoginRequest request) {

        // 1️⃣ Authenticate user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        if (!authentication.isAuthenticated()) {
            throw new RuntimeException("Invalid Credentials");
        }

        // 2️⃣ Fetch user from DB
        User user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 3️⃣ Generate JWT with userId + role
        return jwtUtil.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole().name()
        );
    }
}
