package com.interviewiq.backend.history;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewHistoryRepository
        extends JpaRepository<InterviewHistory, Long> {

}