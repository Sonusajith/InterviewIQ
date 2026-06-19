package com.interviewiq.backend.history;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

    @Autowired
    private InterviewHistoryRepository repository;

    public void saveInterview(
            String question,
            String answer,
            Integer score,
            String feedback) {

        InterviewHistory history =
                new InterviewHistory();

        history.setQuestion(question);
        history.setAnswer(answer);
        history.setScore(score);
        history.setFeedback(feedback);
        history.setCreatedAt(LocalDateTime.now());

        try {

            System.out.println("saveInterview started");

            repository.save(history);

            System.out.println("saved successfully");

        } catch (Exception e) {

            System.out.println("save failed");
            e.printStackTrace();
        }
    }
}