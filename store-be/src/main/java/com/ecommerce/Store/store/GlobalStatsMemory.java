package com.ecommerce.Store.store;

import com.ecommerce.Store.model.DiscountCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Setter
public class GlobalStatsMemory {
    private int totalItemsPurchased = 0;
    private double totalPurchaseAmount = 0.0;
    private final List<DiscountCode> appliedCoupons = new ArrayList<>();
    private double totalDiscountAmount = 0.0;

    public void addPurchase(int itemCount, double amount, DiscountCode appliedCode) {
        totalItemsPurchased += itemCount;
        totalPurchaseAmount += amount;

        if (appliedCode != null && !appliedCode.isUsed()) {
            appliedCoupons.add(appliedCode);
            double discountAmount = amount * (appliedCode.getDiscountPercent() / 100.0);
            totalDiscountAmount += discountAmount;
        }
    }
}
