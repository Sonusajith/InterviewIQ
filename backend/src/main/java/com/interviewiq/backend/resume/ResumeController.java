package com.interviewiq.backend.resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.interviewiq.backend.resume.dto.ResumeResponse;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping("/upload")
    public ResumeResponse  uploadResume(
            @RequestParam("file") MultipartFile file) {

        return resumeService.uploadResume(file);
    }
}