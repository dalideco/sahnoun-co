package com.sahnounco.recruitmentapp.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    // Health check endpoint
    @GetMapping("/")
    public String healthCheck() {
        return "Recruitment app is running";
    }
}