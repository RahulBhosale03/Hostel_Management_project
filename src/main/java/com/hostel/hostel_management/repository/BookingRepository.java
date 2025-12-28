package com.hostel.hostel_management.repository;

import com.hostel.hostel_management.entity.Booking;
import com.hostel.hostel_management.entity.User;
import com.hostel.hostel_management.enums.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {

    List<Booking> findByUser(User user);

    List<Booking> findByActive(boolean active);

    long countByPaymentStatus(PaymentStatus status);

//    long countByPaymentStatus(PaymentStatus status);
    List<Booking> findByPaymentStatus(PaymentStatus status);

    List<Booking> findByEndDate(LocalDate endDate);


}
