package com.hostel.hostel_management.scheduler;

import com.hostel.hostel_management.entity.Booking;
import com.hostel.hostel_management.repository.BookingRepository;
import com.hostel.hostel_management.service.EmailService;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.util.List;

public class RentReminderScheduler {

    private final BookingRepository bookingRepository;
    private final EmailService emailService;

    public RentReminderScheduler(BookingRepository bookingRepository, EmailService emailService) {
        this.bookingRepository = bookingRepository;
        this.emailService = emailService;
    }

//    @Scheduled(cron = "0 0 9 * * ?")
    @Scheduled(fixedRate = 60000)
    public void sendEndDateReminderEmails(){

        LocalDate reminderDate = LocalDate.now().plusDays(3);

        List<Booking> bookings = bookingRepository.findByEndDate(reminderDate);

        for (Booking booking : bookings) {
            emailService.sendRendReminder(
                    booking.getUser().getEmail(),
                    booking.getUser().getName(),
                    booking.getEndDate()
            );
        }

    }
}
