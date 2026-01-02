package com.hostel.hostel_management.serviceImpl;

import com.hostel.hostel_management.dto.BookingRequest;
import com.hostel.hostel_management.dto.BookingResponse;
import com.hostel.hostel_management.entity.Booking;
import com.hostel.hostel_management.entity.Room;
import com.hostel.hostel_management.entity.User;
import com.hostel.hostel_management.enums.PaymentStatus;
import com.hostel.hostel_management.repository.BookingRepository;
import com.hostel.hostel_management.repository.RoomRepository;
import com.hostel.hostel_management.repository.UserRepository;
import com.hostel.hostel_management.service.BookingService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepo;
    private final RoomRepository roomRepo;
    private final UserRepository userRepo;

    public BookingServiceImpl(BookingRepository bookingRepo, RoomRepository roomRepo, UserRepository userRepo) {
        this.bookingRepo = bookingRepo;
        this.roomRepo = roomRepo;
        this.userRepo = userRepo;
    }

    @Override
    public BookingResponse createBooking(Long userId, BookingRequest request) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Room room = roomRepo.findById(request.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        // ✅ STRING → LOCALDATE CONVERSION (FIX)
        LocalDate startDate = LocalDate.parse(request.getStartDate());
        LocalDate endDate = LocalDate.parse(request.getEndDate());

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setRoom(room);
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        booking.setActive(true);

        bookingRepo.save(booking);

        return new BookingResponse(
                booking.getId(),
                user.getId(),
                room.getId(),
                booking.getStartDate().toString(),
                booking.getEndDate().toString(),
                booking.getActive()
        );
    }

    @Override
    public List<BookingResponse> getUserBookings(Long userId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

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
                .toList();
    }


    @Override
    public List<BookingResponse> getAllBookings() {

        return bookingRepo.findAll()
                .stream()
                .map(b -> new BookingResponse(
                        b.getId(),
                        b.getUser().getId(),
                        b.getRoom().getId(),
                        b.getStartDate().toString(),
                        b.getEndDate().toString(),
                        b.getActive()
                ))
                .toList();
    }

    @Override
    public void cancelBooking(Long bookingId) {

        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setActive(false);
        bookingRepo.save(booking);
    }
}
