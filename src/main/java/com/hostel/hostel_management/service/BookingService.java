package com.hostel.hostel_management.service;

import com.hostel.hostel_management.dto.BookingRequest;
import com.hostel.hostel_management.dto.BookingResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {

    BookingResponse createBooking(Long userId, BookingRequest request);

    List<BookingResponse> getUserBookings(Long userId);

    List<BookingResponse> getAllBookings();

    void cancelBooking(Long bookingId);
}
