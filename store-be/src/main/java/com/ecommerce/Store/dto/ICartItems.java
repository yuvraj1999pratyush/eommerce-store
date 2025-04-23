package com.ecommerce.Store.dto;

import com.ecommerce.Store.model.CartItem;
import com.ecommerce.Store.model.DiscountCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

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

    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record validateResponse(
            @JsonProperty("is_coupon_eligible") boolean isCouponEligible
    ) {

    }

    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record BuyRequest(
            @JsonProperty("user_id") String userId,
            DiscountCode coupon
    ) {

    }

    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record BuyResponse(
            @JsonProperty("order_items") int orderItems,
            @JsonProperty("order_amount") double orderAmount,
            @JsonProperty("discount_amount") double discountAmount
    ) {

    }
}
