package com.dtech.blog.blog_api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dtech.blog.blog_api.services.OpenAIService;

@RestController
@RequestMapping("/api")
public class SummaryController {

    @Autowired
    private OpenAIService openAIService;

    @PostMapping("/summarize")
    public String summarizeBlog(@RequestBody String blogContent) {
        return openAIService.generateSummary(blogContent);
    }
}

