package com.cognixia.capstoneproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/version")
public class VersionController {
    @GetMapping
    public String healthCheck() {
        return "v1";
    }
}
