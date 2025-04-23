package com.ecommerce.Store.service;

import com.ecommerce.Store.dto.ICartItems;
import com.ecommerce.Store.model.CartItem;
import com.ecommerce.Store.model.Item;
import com.ecommerce.Store.store.CartMemory;
import com.ecommerce.Store.store.CouponMemory;
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
    private final CouponMemory couponMemory;

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

    public void removeItemFromCart(ICartItems.Request request) {
        String userId = request.userId();
        String itemId = request.id();
        log.info("[removeItemFromCart] Removing item from cart for user: {}", userId);

        if (Objects.isNull(itemId) || !StringUtils.hasLength(itemId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please select an item");
        }

        // Get user's cart
        List<CartItem> userCart = cartMemory.getCart(userId);
        Optional<CartItem> existingCartItem = userCart.stream()
                .filter(item -> item.getId().equals(itemId))
                .findFirst();

        if (existingCartItem.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Item not present in cart");
        }

        CartItem cartItem = existingCartItem.get();

        // Get the store item
        Item storeItem = storeMemory.getItemById(itemId);
        if (storeItem == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found in store");
        }

        // Check if the item's current quantity exceeds initial quantity
        if (storeItem.getQuantity() >= storeItem.getInitialQuantity()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Item stock already full in store");
        }

        // Add an item to store quantity
        storeItem.setQuantity(storeItem.getQuantity() + 1);
        log.info("[removeItemFromCart] Updated store quantity for item: {} | quantity: {}", itemId, storeItem.getQuantity());

        // Remove from cart
        if (cartItem.getCount() > 1) {
            cartItem.setCount(cartItem.getCount() - 1);
            log.info("[removeItemFromCart] Decreased cart item count for user: {}", userId);
        } else {
            userCart.remove(cartItem);
            log.info("[removeItemFromCart] Removed item from cart for user: {}", userId);
        }

        // Update cart
        cartMemory.updateCart(userId, userCart);
        log.info("[removeItemFromCart] Cart updated for user: {}", userId);
    }

    public ICartItems.Response getCartItems(String userId) {
        log.info("[getCartItems] Getting latest cart item for user: {}", userId);

        List<CartItem> cartItems = cartMemory.getCart(userId);

        log.info("[getCartItems] Got added cart items for user: {}", userId);

        return ICartItems.Response.builder()
                .cartItems(cartItems)
                .build();
    }

    public ICartItems.validateResponse isUserEligibleForCoupon(String userId) {
        log.info("[isUserEligibleForCoupon] validating if coupon is valid for: {}", userId);
        boolean isCouponEligible = couponMemory.isEligibleForNewCoupon();
        log.info("[isUserEligibleForCoupon] got response isCouponEligible:{} for user: {}", isCouponEligible, userId);
        return ICartItems.validateResponse.builder().isCouponEligible(isCouponEligible).build();
    }

}
