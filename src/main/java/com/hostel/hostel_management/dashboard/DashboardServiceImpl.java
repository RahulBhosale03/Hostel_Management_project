package com.hostel.hostel_management.dashboard;

import com.hostel.hostel_management.dashboard.dto.ChartDataResponse;
import com.hostel.hostel_management.dashboard.dto.UnpaidRentResponse;
import com.hostel.hostel_management.entity.Booking;
import com.hostel.hostel_management.entity.User;
import com.hostel.hostel_management.enums.PaymentStatus;
import com.hostel.hostel_management.enums.TicketStatus;
import com.hostel.hostel_management.repository.BookingRepository;
import com.hostel.hostel_management.repository.ComplaintRepository;
import com.hostel.hostel_management.repository.RoomRepository;
import com.hostel.hostel_management.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DashboardServiceImpl implements DashboardService{

    private final UserRepository userRepo;
    private final RoomRepository roomRepo;
    private final BookingRepository bookingRepo;
    private final ComplaintRepository complaintRepo;

    public DashboardServiceImpl(UserRepository userRepo, RoomRepository roomRepo, BookingRepository bookingRepo, ComplaintRepository complaintRepo) {
        this.userRepo = userRepo;
        this.roomRepo = roomRepo;
        this.bookingRepo = bookingRepo;
        this.complaintRepo = complaintRepo;
    }

    @Override
    public UserDashboardResponse getUserDashboard(Long userId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserDashboardResponse res = new UserDashboardResponse();

        Booking booking = bookingRepo.findByUser(user)
                .stream()
                .filter(Booking::getActive)
                .findFirst()
                .orElse(null);

        if (booking != null) {
            res.setBookingActive(true);
            res.setRoomNumber(booking.getRoom().getRoomNumber());
            res.setPaymentStatus(booking.getPaymentStatus());
            res.setRentDueDate(booking.getEndDate());
        }

        res.setTotalComplaints(complaintRepo.countByUser(user));
        res.setOpenComplaints(
                complaintRepo.countByUserAndStatus(user, TicketStatus.OPEN)
        );
        return res;
    }

    @Override
    public AdminDashboardResponse getAdminDashboard() {

        AdminDashboardResponse res = new AdminDashboardResponse();

        res.setTotalUsers(userRepo.count());
        res.setTotalRooms(roomRepo.count());
        res.setTotalBookings(bookingRepo.count());

        res.setPendingRentCount(
                bookingRepo.countByPaymentStatus(PaymentStatus.PENDING)
        );

        res.setOpenTickets(
                complaintRepo.countByStatus(TicketStatus.OPEN)
        );

        return res;
    }

    @Override
    public List<ChartDataResponse> getBookingPaymentChart() {
        List<ChartDataResponse> chart = new ArrayList<>();

        chart.add(new ChartDataResponse(
                "PAID",
                bookingRepo.countByPaymentStatus(PaymentStatus.SUCCESS)
        ));

        chart.add(new ChartDataResponse(
                "PENDING",
                bookingRepo.countByPaymentStatus(PaymentStatus.PENDING)
        ));

        return chart;
    }

    @Override
    public List<ChartDataResponse> getComplaintStatusChart() {
        List<ChartDataResponse> chart = new ArrayList<>();

        chart.add(new ChartDataResponse(
                "OPEN",
                complaintRepo.countByStatus(TicketStatus.OPEN)
        ));

        chart.add(new ChartDataResponse(
                "IN_PROGRESS",
                complaintRepo.countByStatus(TicketStatus.IN_PROGRESS)
        ));

        chart.add(new ChartDataResponse(
                "RESOLVED",
                complaintRepo.countByStatus(TicketStatus.RESOLVED)
        ));

        return chart;
    }

    @Override
    public List<UnpaidRentResponse> getUnpaidRentList() {
        return bookingRepo.findByPaymentStatus(PaymentStatus.PENDING)
                .stream()
                .map(b -> new UnpaidRentResponse(
                        b.getId(),
                        b.getUser().getName(),
                        b.getUser().getEmail(),
                        b.getRoom().getRoomNumber(),
                        b.getEndDate()
                ))
                .toList();
    }
}
