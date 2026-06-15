package com.interviewiq.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interviewiq.backend.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    boolean existsByEmail(String email);
}