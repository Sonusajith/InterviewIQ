package com.interviewiq.backend.interview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interviewiq.backend.gemini.GeminiService;

@Service
public class InterviewService {

    @Autowired
    private GeminiService geminiService;

    public String generateQuestions(String skills) {

        String prompt =
                "Generate only 10 technical interview questions for these skills:\n"
                + skills +
                "\n\nDo not provide resume review. Return only questions.";

        return geminiService.askGemini(prompt);
    }
}
