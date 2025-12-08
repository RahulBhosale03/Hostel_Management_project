package com.hostel.hostel_management.controller;

import com.hostel.hostel_management.dto.RoomResponse;
import com.hostel.hostel_management.entity.Room;
import com.hostel.hostel_management.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/rooms")
    public ResponseEntity<RoomResponse> addRoom(@RequestBody Room room){
        return ResponseEntity.ok(adminService.addRooms(room));
    }

    @PutMapping("/rooms/{roomId}")
    public ResponseEntity<RoomResponse> updateRooms(
            @PathVariable Long roomId,
            @RequestBody Room room){
        return ResponseEntity.ok(adminService.updateRooms(roomId,room));
    }

    @DeleteMapping("/rooms/{roomId}")
    public ResponseEntity<String> deleteRoom(@PathVariable Long roomId){
        adminService.deleteRoom(roomId);
        return ResponseEntity.ok("Room deleted successfully");
    }

    @GetMapping("/rooms")
    public ResponseEntity<List<RoomResponse>> getAllRooms(){
        return ResponseEntity.ok(adminService.getAllRooms());
    }

    @GetMapping("/users")
    public ResponseEntity<List<?>> getAllUsers(){
        return ResponseEntity.ok(adminService.getAllUsers());
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<?>> getAllBookings(){
        return ResponseEntity.ok(adminService.getAllBookings());
    }

    @GetMapping("/complaints")
    public ResponseEntity<List<?>> getAllComplaints(){
        return ResponseEntity.ok(adminService.getAllComplaints());
    }

}
