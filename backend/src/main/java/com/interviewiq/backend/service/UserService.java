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
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public User updateUser(Long id, User updatedUser) {

        User existingUser = userRepository.findById(id).orElse(null);

        if(existingUser == null) {
            return null;
        }

        existingUser.setName(updatedUser.getName());
        existingUser.setCollege(updatedUser.getCollege());
        existingUser.setBranch(updatedUser.getBranch());
        existingUser.setGraduationYear(updatedUser.getGraduationYear());
        existingUser.setSkills(updatedUser.getSkills());

        return userRepository.save(existingUser);
    }
    @Autowired
    private PasswordEncoder passwordEncoder;
}