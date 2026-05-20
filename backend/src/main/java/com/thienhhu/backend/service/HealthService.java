package com.thienhhu.backend.service;

import org.springframework.stereotype.Service;

@Service
public class HealthService {

    public String getHealthMessage() {
        return "Backend running";
    }
}
