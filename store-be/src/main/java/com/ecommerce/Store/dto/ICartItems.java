package com.ecommerce.Store.dto;

import com.ecommerce.Store.model.CartItem;
import com.ecommerce.Store.model.Item;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.HashMap;
import java.util.List;

public interface ICartItems {
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record Request(
            @JsonProperty("user_id") String userId,
            String id
    ) {

    }

    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record Response(
            @JsonProperty("cart_items") List<CartItem> cartItems
    ) {
    }
}
