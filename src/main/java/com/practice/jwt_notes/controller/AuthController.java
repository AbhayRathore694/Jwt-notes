package com.practice.jwt_notes.controller;

import com.practice.jwt_notes.config.JwtUtil;
import com.practice.jwt_notes.dto.AuthRequest;
import com.practice.jwt_notes.dto.AuthResponse;
import com.practice.jwt_notes.entity.User;
import com.practice.jwt_notes.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody AuthRequest request) {

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        userService.register(user);

        return "User registered successfully";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        User user = userService.authenticate(
                request.getUsername(),
                request.getPassword()
        );

        String token = jwtUtil.generateToken(user.getUsername());

        return new AuthResponse(token);
    }

}
