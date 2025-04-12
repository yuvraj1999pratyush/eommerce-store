package com.ecommerce.Store.controller;

import com.ecommerce.Store.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/store/items")
public class ItemsController {

    @Autowired
    ItemsService itemsService;

    @GetMapping("/health")
    public String checkHealth() {
        return itemsService.getHealth();
    }
}
