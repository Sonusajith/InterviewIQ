package com.interviewiq.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.interviewiq.backend.entity.User;
import com.interviewiq.backend.service.UserService;

import com.interviewiq.backend.dto.LoginRequest;
import com.interviewiq.backend.jwt.JwtUtil;
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {

        User savedUser = userService.registerUser(user);

        if(savedUser == null) {
            return "Email already exists";
        }

        return "User Registered Successfully";
    }
    
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        boolean success =
                userService.login(
                        request.getEmail(),
                        request.getPassword());

        if(success) {
            return JwtUtil.generateToken(
                    request.getEmail());
        }

        return "Invalid Credentials";
    }
}