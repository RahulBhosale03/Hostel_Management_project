package com.hostel.hostel_management.serviceImpl;

import com.hostel.hostel_management.config.JwtUtil;
import com.hostel.hostel_management.config.UserDetailsServiceImpl;
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
//import com.hostel.hostel_management.config.JwtUtil;

@Service
public class AuthServiceImpl implements AuthService {


    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsServiceImpl userDetailsService;

    public AuthServiceImpl(UserRepository userRepo, PasswordEncoder passwordEncoder,
                           AuthenticationManager authenticationManager,
                           JwtUtil jwtUtil,
                           UserDetailsServiceImpl userDetailsService) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public UserResponse register(RegisterRequest request) {

        if(userRepo.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already exist");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(RoleType.USER);

        User saved = userRepo.save(user);
        return new UserResponse(saved.getId(), saved.getName(),
                saved.getEmail(), saved.getRole());
    }

    @Override
    public String login(LoginRequest request) {

        Authentication auth  = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),request.getPassword()
                )
        );

        if(!auth.isAuthenticated()){
            throw new RuntimeException("Invalid Credentials");
        }
        return jwtUtil.generateToken(auth.getName());
    }
}
