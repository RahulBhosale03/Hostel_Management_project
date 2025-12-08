package com.hostel.hostel_management.service;

import com.hostel.hostel_management.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<RoomResponse> listAvailableRoom();

    BookingResponse bookRoom(Long userId , BookingRequest request);

    List<BookingResponse> userBooking(Long userId);

    ComplaintResponse createComplaint(Long UserId , ComplaintRequest request);

    List<ComplaintResponse> getUserComplaint(Long userId);


}
