package com.ecommerce.Store.service;

import com.ecommerce.Store.dto.IAdmin;
import com.ecommerce.Store.model.DiscountCode;
import com.ecommerce.Store.store.CouponMemory;
import com.ecommerce.Store.store.GlobalStatsMemory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminService {

    @Autowired
    CartService cartService;

    private final CouponMemory couponMemory;
    private final GlobalStatsMemory globalStatsMemory;

    public IAdmin.CouponRes generateNewCoupon() {
        log.info("[generateNewCoupon] Admin generating new coupon");

        if (!couponMemory.isEligibleForNewCoupon()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Coupon cannot be generated");
        }

        String code = "SAVE10-" + UUID.randomUUID().toString().substring(0, 4).toUpperCase();
        DiscountCode discountCode = new DiscountCode(code, false, 10.0, true);
        log.info("[generateNewCoupon] Admin generated coupon code :{} successfully", code);

        return IAdmin.CouponRes.builder().coupon(discountCode).build();
    }

    public IAdmin.GlobalStatsRes getGlobalStats() {
        log.info("[getGlobalStats] Getting global stats");
        return IAdmin.GlobalStatsRes.builder()
                .totalItemsPurchased(globalStatsMemory.getTotalItemsPurchased())
                .totalPurchaseAmount(globalStatsMemory.getTotalPurchaseAmount())
                .appliedCoupons(globalStatsMemory.getAppliedCoupons())
                .totalDiscountAmount(globalStatsMemory.getTotalDiscountAmount())
                .build();
    }
}
