package com.hostel.hostel_management.repository;

import com.hostel.hostel_management.entity.Payment;
import com.hostel.hostel_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

    List<Payment> findByUser(User user);

    Payment findByTransactionId(String transactionId);
}
