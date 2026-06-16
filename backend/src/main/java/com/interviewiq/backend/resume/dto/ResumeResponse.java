package com.interviewiq.backend.resume.dto;

import java.util.List;

public class ResumeResponse {

    private int atsScore;
    private List<String> detectedSkills;
    private List<String> missingSkills;

    public ResumeResponse(int atsScore,
                          List<String> detectedSkills,
                          List<String> missingSkills) {
        this.atsScore = atsScore;
        this.detectedSkills = detectedSkills;
        this.missingSkills = missingSkills;
    }

    public int getAtsScore() {
        return atsScore;
    }

    public List<String> getDetectedSkills() {
        return detectedSkills;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }
}