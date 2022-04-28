package com.cognixia.capstoneproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ping")
public class HealthCheckController {
    @GetMapping
    public String healthCheck() {
        return "pong";
    }
}
