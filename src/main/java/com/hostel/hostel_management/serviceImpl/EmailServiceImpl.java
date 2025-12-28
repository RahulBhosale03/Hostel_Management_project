package com.hostel.hostel_management.serviceImpl;

import com.hostel.hostel_management.service.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;


    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendRendReminder(String email, String userName, LocalDate endDate) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Hostel Rent Reminder");
        message.setText(
                "Hello" + userName +",\n\n"+
                        "This is a reminder that your hostel rent is due on "+ endDate + ".\n"+
                        "Please ensure timely payment.\n\n"+
                        "Regards,\nHostel Management"
        );
        mailSender.send(message);
    }
}
