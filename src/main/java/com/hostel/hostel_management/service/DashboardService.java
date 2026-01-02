package com.hostel.hostel_management.service;

import com.hostel.hostel_management.dto.AdminDashboardResponse;
import com.hostel.hostel_management.dto.UserDashboardResponse;
import com.hostel.hostel_management.dashboard.dto.ChartDataResponse;
import com.hostel.hostel_management.dashboard.dto.UnpaidRentResponse;

import java.util.List;

public interface DashboardService {

    UserDashboardResponse getUserDashboard(Long userId);

    AdminDashboardResponse getAdminDashboard();

    List<ChartDataResponse> getBookingPaymentChart();
    List<ChartDataResponse> getComplaintStatusChart();
    List<UnpaidRentResponse> getUnpaidRentList();
}
