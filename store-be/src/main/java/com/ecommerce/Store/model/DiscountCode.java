package com.ecommerce.Store.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountCode {
    private String code;
    @JsonProperty("is_used")
    private boolean isUsed;
    @JsonProperty("discount_percent")
    private double discountPercent;
    @JsonProperty("is_valid")
    private boolean isValid;
}
