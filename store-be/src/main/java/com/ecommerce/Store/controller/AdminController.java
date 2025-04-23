package com.ecommerce.Store.controller;

import com.ecommerce.Store.dto.IAdmin;
import com.ecommerce.Store.model.DiscountCode;
import com.ecommerce.Store.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/store/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("/coupon/generate")
    public IAdmin.CouponRes generateNewCoupon() {
        return adminService.generateNewCoupon();
    }

    @GetMapping("/global/stats")
    public IAdmin.GlobalStatsRes getGlobalStats() {
        return adminService.getGlobalStats();
    }

}
