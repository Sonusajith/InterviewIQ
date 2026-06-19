package com.interviewiq.backend.history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/history")
public class HistoryController {

    @Autowired
    private InterviewHistoryRepository repository;

    @GetMapping
    public List<InterviewHistory> getAllHistory() {

        return repository.findAll();
    }
}