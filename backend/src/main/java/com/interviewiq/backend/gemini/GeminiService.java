package com.interviewiq.backend.gemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    @Autowired
    private WebClient webClient;

    public String listModels() {

        return webClient.get()
                .uri("https://generativelanguage.googleapis.com/v1beta/models?key=" + apiKey)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String reviewResume(String resumeText) {

        String prompt =
                "Review this resume and provide improvement suggestions:\n\n"
                + resumeText;

        return askGemini(prompt);
    }

    public String askGemini(String prompt) {

        String requestBody =
                """
                {
                  "contents": [{
                    "parts": [{
                      "text": "%s"
                    }]
                  }]
                }
                """.formatted(prompt.replace("\"", "\\\""));

        try {

            return webClient.post()
                    .uri("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=" + apiKey)
                    .header("Content-Type", "application/json")
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

        } catch (Exception e) {

            e.printStackTrace();
            return e.toString();
        }
    }
}