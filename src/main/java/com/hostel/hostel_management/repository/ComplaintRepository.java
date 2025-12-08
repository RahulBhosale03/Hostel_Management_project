package com.hostel.hostel_management.repository;

import com.hostel.hostel_management.entity.Booking;
import com.hostel.hostel_management.entity.Complaint;
import com.hostel.hostel_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint,Long> {

    List<Complaint> findByUser(User user);

    List<Complaint> findByResolved(boolean resolved);


}
