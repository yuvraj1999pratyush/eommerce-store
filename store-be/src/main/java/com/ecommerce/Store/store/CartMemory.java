package com.ecommerce.Store.store;

import com.ecommerce.Store.model.CartItem;
import com.ecommerce.Store.model.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CartMemory {
    private final Map<String, List<CartItem>> userCarts = new HashMap<>();

    public List<CartItem> getCart(String userId) {
        return userCarts.getOrDefault(userId, new ArrayList<>());
    }

    public void updateCart(String userId, List<CartItem> updatedCart) {
        userCarts.put(userId, updatedCart);
    }
}
