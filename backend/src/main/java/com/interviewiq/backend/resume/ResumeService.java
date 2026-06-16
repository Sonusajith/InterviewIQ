package com.interviewiq.backend.resume;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.interviewiq.backend.resume.dto.ResumeResponse;
@Service
public class ResumeService {
	private static final String[] SKILLS = {
		    "Java",
		    "Spring Boot",
		    "MySQL",
		    "React",
		    "Angular",
		    "JavaScript",
		    "Python",
		    "Docker",
		    "AWS",
		    "Git",
		    "Hibernate",
		    "REST API",
		    "Microservices"
		};

    public ResumeResponse  uploadResume(MultipartFile file) {

        try {

            PDDocument document =
                    PDDocument.load(file.getInputStream());

            PDFTextStripper pdfStripper =
                    new PDFTextStripper();

            String text = pdfStripper.getText(document);

            List<String> detectedSkills = new ArrayList<>();

            for(String skill : SKILLS) {

                if(text.toLowerCase()
                        .contains(skill.toLowerCase())) {

                    detectedSkills.add(skill);
                }
            }
            List<String> missingSkills = new ArrayList<>();

            for(String skill : SKILLS) {

                if(!detectedSkills.contains(skill)) {
                    missingSkills.add(skill);
                }
            }
            int atsScore =
                    (detectedSkills.size() * 100) / SKILLS.length;
            document.close();

            return new ResumeResponse(
                    atsScore,
                    detectedSkills,
                    missingSkills);
            

        } catch (IOException e) {

        	return new ResumeResponse(
        	        0,
        	        new ArrayList<>(),
        	        new ArrayList<>());
        }
    }
}