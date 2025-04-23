package com.ecommerce.Store.store;

import com.ecommerce.Store.model.DiscountCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Getter
@Setter
public class CouponMemory {

    private DiscountCode currentCoupon = null;
    private final int NTH_ORDER = 5;
    private int orderCount = 0;

    public boolean isEligibleForNewCoupon() {
        return orderCount > 0 && orderCount % NTH_ORDER == 0 && currentCoupon == null;
    }

    public void incrementOrderCount() {
        orderCount++;
    }

    public void markCouponUsed() {
        if (currentCoupon != null) {
            currentCoupon.setUsed(true);
        }
    }

    public boolean isCouponValid(String code) {
        return currentCoupon != null && !currentCoupon.isUsed() && currentCoupon.getCode().equals(code);
    }
}