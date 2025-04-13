package com.ecommerce.Store.controller;

import com.ecommerce.Store.dto.IItems;
import com.ecommerce.Store.service.ItemsService;
import com.ecommerce.Store.store.StoreMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/store/items")
public class ItemsController {

    @Autowired
    ItemsService itemsService;

    @GetMapping("/health")
    public String checkHealth() {
        return itemsService.getHealth();
    }

    @GetMapping("/all")
    public IItems.Response getAllItems() {
        return itemsService.getAllItems();
    }
}
