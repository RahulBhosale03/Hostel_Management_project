package com.hostel.hostel_management.dashboard;

public class AdminDashboardResponse {
    private long totalUsers;
    private long totalRooms;
    private long totalBookings;

    private long pendingRentCount;
    private long openTickets;

    public AdminDashboardResponse() {}

    public long getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(long totalUsers) {
        this.totalUsers = totalUsers;
    }

    public long getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(long totalRooms) {
        this.totalRooms = totalRooms;
    }

    public long getTotalBookings() {
        return totalBookings;
    }

    public void setTotalBookings(long totalBookings) {
        this.totalBookings = totalBookings;
    }

    public long getOpenTickets() {
        return openTickets;
    }

    public void setOpenTickets(long openTickets) {
        this.openTickets = openTickets;
    }

    public long getPendingRentCount() {
        return pendingRentCount;
    }

    public void setPendingRentCount(long pendingRentCount) {
        this.pendingRentCount = pendingRentCount;
    }
}
