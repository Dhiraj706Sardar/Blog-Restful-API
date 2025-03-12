package com.dtech.blog.blog_api.services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
public class OpenAIService {

    @Value("${openai.api.key}")
    private String openaiApiKey;

    @Value("${openai.api.url}")
    private String openaiApiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public String generateSummary(String blogContent) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + openaiApiKey);

        // Prepare request payload
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "gpt-3.5-turbo");
        requestBody.put("messages", List.of(
                Map.of("role", "system", "content", "You are a helpful AI that summarizes blogs."),
                Map.of("role", "user", "content", "Summarize this blog: " + blogContent)
        ));
        requestBody.put("max_tokens", 100);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<Map> response = restTemplate.exchange(openaiApiUrl, HttpMethod.POST, requestEntity, Map.class);

        // Extract response
        List<Map<String, Object>> choices = (List<Map<String, Object>>) response.getBody().get("choices");
        return choices.get(0).get("message").toString();
    }
}
