package com.interviewiq.backend.gemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gemini")
public class GeminiController {

    @Autowired
    private GeminiService geminiService;

    @PostMapping("/review")
    public String reviewResume(
            @RequestBody ResumeReviewRequest request) {

        return geminiService.reviewResume(
                request.getResumeText());
    }
    @GetMapping("/models")
    public String models() {
        return geminiService.listModels();
    }
}