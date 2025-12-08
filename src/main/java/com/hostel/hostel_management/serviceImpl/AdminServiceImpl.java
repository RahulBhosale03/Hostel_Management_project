package com.hostel.hostel_management.serviceImpl;

import com.hostel.hostel_management.dto.RoomResponse;
import com.hostel.hostel_management.entity.Booking;
import com.hostel.hostel_management.entity.Complaint;
import com.hostel.hostel_management.entity.Room;
import com.hostel.hostel_management.entity.User;
import com.hostel.hostel_management.repository.BookingRepository;
import com.hostel.hostel_management.repository.ComplaintRepository;
import com.hostel.hostel_management.repository.RoomRepository;
import com.hostel.hostel_management.repository.UserRepository;
import com.hostel.hostel_management.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    private final RoomRepository roomRepo;
    private final UserRepository userRepo;
    private final BookingRepository bookingRepo;
    private final ComplaintRepository complaintRepo;

    public AdminServiceImpl(RoomRepository roomRepo, UserRepository userRepo,
                            BookingRepository bookingRepo,
                            ComplaintRepository complaintRepo) {
        this.roomRepo = roomRepo;
        this.userRepo = userRepo;
        this.bookingRepo = bookingRepo;
        this.complaintRepo = complaintRepo;
    }

    @Override
    public RoomResponse addRooms(Room room) {
        Room saved = roomRepo.save(room);
        return new RoomResponse(
                saved.getId(),
                saved.getRoomNumber(),
                saved.getPricePerMonth(),
                saved.isAvailable(),
                saved.getDescription()
        );
    }

    @Override
    public RoomResponse updateRooms(Long roomId, Room updatedRoom) {

        Room room = roomRepo.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        room.setRoomNumber(updatedRoom.getRoomNumber());
        room.setPricePerMonth(updatedRoom.getPricePerMonth());
        room.setAvailable(updatedRoom.isAvailable());
        room.setDescription(updatedRoom.getDescription());

        Room saved = roomRepo.save(room);
        return new RoomResponse(
                saved.getId(),
                saved.getRoomNumber(),
                saved.getPricePerMonth(),
                saved.isAvailable(),
                saved.getDescription()
        );
    }

    @Override
    public void deleteRoom(Long roomId) {
        if (!roomRepo.existsById(roomId)) {
            throw new RuntimeException("Room not found");
        }
        roomRepo.deleteById(roomId);
    }

    @Override
    public List<RoomResponse> getAllRooms() {
        return roomRepo.findAll()
                .stream()
                .map(room -> new RoomResponse(
                        room.getId(),
                        room.getRoomNumber(),
                        room.getPricePerMonth(),
                        room.isAvailable(),
                        room.getDescription()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    @Override
    public List<Complaint> getAllComplaints() {
        return complaintRepo.findAll();
    }
}
