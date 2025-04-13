package com.ecommerce.Store.service;

import com.ecommerce.Store.dto.ICartItems;
import com.ecommerce.Store.model.CartItem;
import com.ecommerce.Store.model.Item;
import com.ecommerce.Store.store.CartMemory;
import com.ecommerce.Store.store.StoreMemory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class CartService {

    private final StoreMemory storeMemory;
    private final CartMemory cartMemory;

    public void addItemToCart(ICartItems.Request request) {
        String userId = request.userId();
        String itemId = request.id();
        log.info("[addItemToCart] Adding item to cart for user: {}", userId);

        if (Objects.isNull(itemId) || !StringUtils.hasLength(itemId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please select an item");
        }

        // Find item in store
        Item storeItem = storeMemory.getItems()
                .stream()
                .filter(item -> item.getId().equals(itemId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found"));

        if (storeItem.getQuantity() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Item out of stock");
        }

        //reduce item quantity by 1
        storeItem.setQuantity(storeItem.getQuantity() - 1);
        log.info("[addItemToCart] Updated store item quantity for user: {}", userId);

        //update item for cart
        List<CartItem> userCart = cartMemory.getCart(userId);
        Optional<CartItem> existingCartItem = userCart.stream()
                .filter(item -> item.getId().equals(itemId))
                .findFirst();

        if (existingCartItem.isPresent()) {
            existingCartItem.get().setCount(existingCartItem.get().getCount() + 1);
        } else {
            userCart.add(new CartItem(
                    storeItem.getId(),
                    storeItem.getImage(),
                    storeItem.getName(),
                    storeItem.getDescription(),
                    storeItem.getPrice(),
                    1
            ));
        }

        //update cart
        cartMemory.updateCart(userId, userCart);
        log.info("[addItemToCart] Cart updated for user: {}", userId);
    }

    public ICartItems.Response getCartItems(String userId) {
        log.info("[getCartItems] Getting latest cart item for user: {}", userId);

        List<CartItem> cartItems = cartMemory.getCart(userId);

        log.info("[getCartItems] Got added cart items for user: {}", userId);

        return ICartItems.Response.builder()
                .cartItems(cartItems)
                .build();
    }

}
