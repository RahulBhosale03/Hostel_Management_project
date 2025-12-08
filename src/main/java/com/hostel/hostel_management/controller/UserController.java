package com.hostel.hostel_management.controller;

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

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/rooms")
    public ResponseEntity<List<RoomResponse>> getAvailableRoom(){
        return ResponseEntity.ok(userService.listAvailableRoom());
    }

    @GetMapping("/{userId}/bookings")
    public ResponseEntity<List<BookingResponse>> getUserBookings(@PathVariable Long userId){
        return ResponseEntity.ok(userService.userBooking(userId));
    }

    @PostMapping("/{userId}/complaints")
    public ResponseEntity<ComplaintResponse> createComplaint(
            @PathVariable Long userId,
            @RequestBody ComplaintRequest request){
        return ResponseEntity.ok(userService.createComplaint(userId,request));
    }

    public ResponseEntity<List<ComplaintResponse>> getUserComplaints(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getUserComplaint(userId));
    }
}
