package com.interviewiq.backend.mockinterview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mock")
public class MockInterviewController {

    @Autowired
    private MockInterviewService mockInterviewService;

    @PostMapping("/evaluate")
    public String evaluate(
            @RequestBody MockInterviewRequest request) {

        return mockInterviewService.evaluateAnswer(
                request.getQuestion(),
                request.getAnswer());
    }
}