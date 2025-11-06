package com.fitness.aiservice.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;


@Service
public class GeminiService {
    private final WebClient webclient;

    @Value("${gemini.api.url}")
    private String geminiApiUrl;

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public GeminiService(WebClient.Builder webclientBuilder) {
        this.webclient = webclientBuilder.build();
    }

    public String getAnswer(String question){
        Map<String, Object> requestBody = Map.of(
                "contents", new Object[] {
                    Map.of("parts", new Object[]{
                            Map.of("text", question)
                    })
                }
        );

        String response = webclient.post()
                .uri(geminiApiUrl + geminiApiKey)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return response;
    }
}
