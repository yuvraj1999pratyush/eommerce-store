package com.ecommerce.Store.dto;

import com.ecommerce.Store.model.DiscountCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

public interface IAdmin {
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record CouponReq() {

    }

    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record CouponRes(
            DiscountCode coupon
    ) {

    }

    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record GlobalStatsRes(
            @JsonProperty("total_items_purchased") int totalItemsPurchased,
            @JsonProperty("total_purchase_amount") double totalPurchaseAmount,
            @JsonProperty("applied_coupons") List<DiscountCode> appliedCoupons,
            @JsonProperty("total_discount_amount") double totalDiscountAmount
    ) {
    }
}
