package com.ecommerce.Store.service;

import com.ecommerce.Store.dto.IItems;
import com.ecommerce.Store.model.Item;
import com.ecommerce.Store.store.StoreMemory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ItemsService {
    @Value("${app.custom.port}")
    private String customPort;

    private final StoreMemory storeMemory;

    public String getHealth() {
        return "Server is healthy and running on port " + customPort;
    }

    public IItems.Response getAllItems() {
        log.info("[getAllItems] Getting all available items from the store");
        List<Item> itemsInStore = storeMemory.getItems();

        log.info("[getAllItems] Got items successfully from the store");
        return IItems.Response.builder().items(itemsInStore).build();
    }

}
