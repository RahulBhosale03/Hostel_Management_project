package com.hostel.hostel_management.repository;

import com.hostel.hostel_management.entity.Booking;
import com.hostel.hostel_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {

    List<Booking> findByUser(User user);

    List<Booking> findByActive(boolean active);

}
