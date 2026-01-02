package com.hostel.hostel_management.controller;

import com.hostel.hostel_management.config.AuthUtil;
import com.hostel.hostel_management.dto.BookingResponse;
import com.hostel.hostel_management.dto.ComplaintRequest;
import com.hostel.hostel_management.dto.ComplaintResponse;
import com.hostel.hostel_management.dto.RoomResponse;
import com.hostel.hostel_management.service.UserService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    private final UserService userService;
    private final AuthUtil authUtil;

    public UserController(UserService userService, AuthUtil authUtil) {
        this.userService = userService;
        this.authUtil = authUtil;
    }

    //USER: View available rooms
    @GetMapping("/rooms")
    public ResponseEntity<List<RoomResponse>> getAvailableRoom() {
        return ResponseEntity.ok(userService.listAvailableRoom());
    }

    //USER: My bookings
    @GetMapping("/bookings")
    public ResponseEntity<List<BookingResponse>> getUserBookings() {

        Long userId = authUtil.getLoggedInUserId();
        return ResponseEntity.ok(
                userService.userBooking(userId)
        );
    }

    //USER: Raise complaint
    @PostMapping("/complaints")
    public ResponseEntity<ComplaintResponse> createComplaint(
            @RequestBody ComplaintRequest request) {

        Long userId = authUtil.getLoggedInUserId();
        return ResponseEntity.ok(
                userService.createComplaint(userId, request)
        );
    }

    //USER: My complaints
    @GetMapping("/complaints")
    public ResponseEntity<List<ComplaintResponse>> getUserComplaints() {

        Long userId = authUtil.getLoggedInUserId();
        return ResponseEntity.ok(
                userService.getUserComplaint(userId)
        );
    }
}
