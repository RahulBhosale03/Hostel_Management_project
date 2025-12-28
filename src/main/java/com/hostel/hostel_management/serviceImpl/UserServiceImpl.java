package com.hostel.hostel_management.serviceImpl;

import com.hostel.hostel_management.dto.*;
import com.hostel.hostel_management.entity.Booking;
import com.hostel.hostel_management.entity.Complaint;
import com.hostel.hostel_management.entity.Room;
import com.hostel.hostel_management.entity.User;
import com.hostel.hostel_management.enums.TicketStatus;
import com.hostel.hostel_management.repository.BookingRepository;
import com.hostel.hostel_management.repository.ComplaintRepository;
import com.hostel.hostel_management.repository.RoomRepository;
import com.hostel.hostel_management.repository.UserRepository;
import com.hostel.hostel_management.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    private final RoomRepository roomRepo;
    private final BookingRepository bookingRepo;
    private final UserRepository userRepo;
    private final ComplaintRepository complaintRepo;

    public UserServiceImpl(RoomRepository roomRepo,
                           BookingRepository bookingRepo, UserRepository userRepo,
                           ComplaintRepository complaintRepo) {
        this.roomRepo = roomRepo;
        this.bookingRepo = bookingRepo;
        this.userRepo = userRepo;
        this.complaintRepo = complaintRepo;
    }

    @Override
    public List<RoomResponse> listAvailableRoom() {
        return roomRepo.findByAvailable(true).stream()
                .map(r -> new RoomResponse(
                        r.getId(),
                        r.getRoomNumber(),
                        r.getPricePerMonth(),
                        r.isAvailable(),
                        r.getDescription()
                )).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public BookingResponse bookRoom(Long userId, BookingRequest request) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Room room = roomRepo.findById(request.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        if (!room.isAvailable()) {
            throw new RuntimeException("Room is not available");
        }

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setRoom(room);
        booking.setActive(true);
        booking.setStartDate(LocalDate.parse(request.getStartDate()));
        booking.setEndDate(LocalDate.parse(request.getEndDate()));

        room.setAvailable(false); // room now booked
        roomRepo.save(room);

        Booking saved = bookingRepo.save(booking);

        return new BookingResponse(
                saved.getId(),
                user.getId(),
                room.getId(),
                saved.getStartDate().toString(),
                saved.getEndDate().toString(),
                saved.getActive()
        );
    }

    @Override
    public List<BookingResponse> userBooking(Long userId) {

        User user = userRepo.findById(userId).orElseThrow(() ->new RuntimeException("User not found"));
        return bookingRepo.findByUser(user)
                .stream()
                .map(b -> new BookingResponse(
                        b.getId(),
                        user.getId(),
                        b.getRoom().getId(),
                        b.getStartDate().toString(),
                        b.getEndDate().toString(),
                        b.getActive()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public ComplaintResponse createComplaint(Long userId, ComplaintRequest request) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Complaint complaint = new Complaint();
        complaint.setUser(user);
        complaint.setMessage(request.getMessage());
        complaint.setCategory(request.getCategory());
        complaint.setStatus(TicketStatus.OPEN);

        Complaint saved = complaintRepo.save(complaint);

        return new ComplaintResponse(
                saved.getId(),
                user.getId(),
                saved.getMessage(),
                saved.getCategory(),
                saved.getStatus(),
                saved.getCreatedAt()
        );
    }

    @Override
    public List<ComplaintResponse> getUserComplaint(Long userId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));


        return complaintRepo.findByUser(user)
                .stream()
                .map(c -> new ComplaintResponse(
                        c.getId(),
                        user.getId(),
                        c.getMessage(),
                        c.getCategory(),
                        c.getStatus(),
                        c.getCreatedAt()   // ✅ FIX
                ))
                .collect(Collectors.toList());
    }

}
