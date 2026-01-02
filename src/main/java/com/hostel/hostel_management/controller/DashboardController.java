package com.hostel.hostel_management.controller;

import com.hostel.hostel_management.config.AuthUtil;
import com.hostel.hostel_management.dto.AdminDashboardResponse;
import com.hostel.hostel_management.service.DashboardService;
import com.hostel.hostel_management.dto.UserDashboardResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;
    private final AuthUtil authUtil;

    public DashboardController(DashboardService dashboardService, AuthUtil authUtil) {
        this.dashboardService = dashboardService;
        this.authUtil = authUtil;
    }

    // USER DASHBOARD
    @GetMapping("/user")
    public ResponseEntity<UserDashboardResponse> userDashboard() {
        Long userId = authUtil.getLoggedInUserId();
        return ResponseEntity.ok(dashboardService.getUserDashboard(userId));
    }

    // ADMIN DASHBOARD
    @GetMapping("/admin")
    public ResponseEntity<AdminDashboardResponse> adminDashboard() {
        return ResponseEntity.ok(dashboardService.getAdminDashboard());
    }

    // Booking Payment Chart
    @GetMapping("/admin/charts/bookings")
    public ResponseEntity<?> bookingChart() {
        return ResponseEntity.ok(dashboardService.getBookingPaymentChart());
    }

    // Complaint Status Chart
    @GetMapping("/admin/charts/complaints")
    public ResponseEntity<?> complaintChart() {
        return ResponseEntity.ok(dashboardService.getComplaintStatusChart());
    }

    //  Unpaid Rent List
    @GetMapping("/admin/unpaid-rents")
    public ResponseEntity<?> unpaidRents() {
        return ResponseEntity.ok(dashboardService.getUnpaidRentList());
    }

}
