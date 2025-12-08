package com.hostel.hostel_management.serviceImpl;

import com.hostel.hostel_management.dto.PaymentRequest;
import com.hostel.hostel_management.dto.PaymentResponse;
import com.hostel.hostel_management.entity.Booking;
import com.hostel.hostel_management.entity.Payment;
import com.hostel.hostel_management.entity.User;
import com.hostel.hostel_management.enums.PaymentStatus;
import com.hostel.hostel_management.repository.BookingRepository;
import com.hostel.hostel_management.repository.PaymentRepository;
import com.hostel.hostel_management.repository.UserRepository;
import com.hostel.hostel_management.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepo;
    private final BookingRepository bookingRepo;
    private final UserRepository userRepo;

    public PaymentServiceImpl(PaymentRepository paymentRepo,
                              BookingRepository bookingRepo,
                              UserRepository userRepo) {
        this.paymentRepo = paymentRepo;
        this.bookingRepo = bookingRepo;
        this.userRepo = userRepo;
    }

    @Override
    public PaymentResponse makePayment(Long userId, PaymentRequest request) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Booking booking = bookingRepo.findById(request.getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        Payment payment = new Payment();
        payment.setUser(user);
//        payment.setBooking(booking);
        payment.setAmount(request.getAmount());
        payment.setMode(request.getMode());
        payment.setStatus(PaymentStatus.SUCCESS); // mock success
        payment.setTransactionId(UUID.randomUUID().toString());

        Payment saved = paymentRepo.save(payment);
        return new PaymentResponse(
                saved.getId(),
                saved.getAmount(),
                saved.getStatus(),
                saved.getMode(),
                saved.getTransactionId()
        );
    }

    @Override
    public PaymentResponse getPaymentIById(Long paymentId) {
        Payment p = paymentRepo.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        return new PaymentResponse(
                p.getId(),
                p.getAmount(),
                p.getStatus(),
                p.getMode(),
                p.getTransactionId()
        );
    }
}
