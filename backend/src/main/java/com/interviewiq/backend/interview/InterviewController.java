package com.interviewiq.backend.interview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interview")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @PostMapping("/questions")
    public String generateQuestions(
            @RequestBody InterviewRequest request) {

        return interviewService.generateQuestions(
                request.getSkills());
    }
}