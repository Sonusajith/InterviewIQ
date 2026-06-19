package com.interviewiq.backend.mockinterview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interviewiq.backend.gemini.GeminiService;
import com.interviewiq.backend.history.HistoryService;

@Service
public class MockInterviewService {
	@Autowired
	private HistoryService historyService;
    @Autowired
    private GeminiService geminiService;

    public String evaluateAnswer(
            String question,
            String answer) {

        String prompt =
                "You are a technical interviewer.\n\n" +
                "Question: " + question + "\n\n" +
                "Candidate Answer: " + answer + "\n\n" +
                "Evaluate the answer.\n" +
                "Give:\n" +
                "1. Score out of 10\n" +
                "2. Strengths\n" +
                "3. Improvements\n" +
                "4. Correct Answer";

        String evaluation =
                geminiService.askGemini(prompt);

        System.out.println("Gemini response received");

        historyService.saveInterview(
                question,
                answer,
                0,
                evaluation);

        System.out.println("History save called");

        return evaluation;
    }
}