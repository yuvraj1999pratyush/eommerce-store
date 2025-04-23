package com.ecommerce.Store.controller;

import com.ecommerce.Store.dto.ICartItems;
import com.ecommerce.Store.model.CartItem;
import com.ecommerce.Store.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/store/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/add")
    @ResponseBody
    public void addItemToCart(@RequestBody ICartItems.Request request) {
        cartService.addItemToCart(request);
    }

    @PostMapping("/remove")
    @ResponseBody
    public void removeItemFromCart(@RequestBody ICartItems.Request request) {
        cartService.removeItemFromCart(request);
    }

    @GetMapping("/all")
    public ICartItems.Response getCartItems(@RequestParam("user_id") String userId) {
        return cartService.getCartItems(userId);
    }

    @GetMapping("/validate")
    public ICartItems.validateResponse validateCouponEligibility(@RequestParam("user_id") String userId) {
        return cartService.isUserEligibleForCoupon(userId);
    }

}
