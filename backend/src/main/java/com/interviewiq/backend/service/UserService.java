package com.interviewiq.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interviewiq.backend.entity.User;
import com.interviewiq.backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {

    	if(userRepository.existsByEmail(user.getEmail())) {
    	    return null;
    	}

        user.setPassword(
            passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }
    public boolean login(String email, String password) {

        User user = userRepository.findByEmail(email);

        if(user == null) {
            return false;
        }

        return passwordEncoder.matches(
                password,
                user.getPassword());
    }
    @Autowired
    private PasswordEncoder passwordEncoder;
}