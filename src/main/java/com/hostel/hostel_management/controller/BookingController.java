package com.hostel.hostel_management.controller;

import com.hostel.hostel_management.config.AuthUtil;
import com.hostel.hostel_management.dto.BookingRequest;
import com.hostel.hostel_management.dto.BookingResponse;
import com.hostel.hostel_management.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;
    private final AuthUtil authUtil;

    public BookingController(BookingService bookingService, AuthUtil authUtil) {
        this.bookingService = bookingService;
        this.authUtil = authUtil;
    }


    // USER: Book a room (JWT based)
    @PostMapping
    public ResponseEntity<BookingResponse> bookRoom(
            @RequestBody BookingRequest request) {

        Long userId = authUtil.getLoggedInUserId();

        return ResponseEntity.ok(
                bookingService.createBooking(userId, request)
        );
    }

    //USER: Get my bookings
    @GetMapping("/my")
    public ResponseEntity<List<BookingResponse>> getMyBookings() {

        Long userId = authUtil.getLoggedInUserId();

        return ResponseEntity.ok(
                bookingService.getUserBookings(userId)
        );
    }

    //USER: Cancel booking
    @PutMapping("/{bookingId}/cancel")
    public ResponseEntity<String> cancelBooking(
            @PathVariable Long bookingId) {

        bookingService.cancelBooking(bookingId);
        return ResponseEntity.ok("Booking cancelled successfully");
    }

    // ADMIN: Get all bookings
    @GetMapping("/admin/all")
    public ResponseEntity<List<BookingResponse>> getAllBookings() {

        return ResponseEntity.ok(
                bookingService.getAllBookings()
        );
    }
}
