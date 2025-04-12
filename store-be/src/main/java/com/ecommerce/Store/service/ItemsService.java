package com.ecommerce.Store.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {
    @Value("${app.custom.port}")
    private String customPort;

    public String getHealth() {
        return "Server is healthy and running on port " + customPort;
    }
}
