package com.thienhhu.backend.controller;

import com.thienhhu.backend.dto.response.HealthResponseDto;
import com.thienhhu.backend.service.HealthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HealthController {

    private final HealthService healthService;

    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping("/health")
    public HealthResponseDto health() {
        return new HealthResponseDto(healthService.getHealthMessage());
    }
}
