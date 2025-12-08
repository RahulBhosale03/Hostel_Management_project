package com.hostel.hostel_management.service;

import com.hostel.hostel_management.dto.RoomResponse;
import com.hostel.hostel_management.entity.Booking;
import com.hostel.hostel_management.entity.Complaint;
import com.hostel.hostel_management.entity.Room;
import com.hostel.hostel_management.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    RoomResponse addRooms(Room room);

    RoomResponse updateRooms(Long roomId , Room updatedRoom);

    void deleteRoom(Long roomId);

    List<RoomResponse> getAllRooms();

    List<User> getAllUsers();

    List<Booking> getAllBookings();

    List<Complaint> getAllComplaints();

//    RoomResponse convertToResponse(Room room);


}
