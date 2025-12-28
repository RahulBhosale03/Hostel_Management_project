package com.hostel.hostel_management.repository;

import com.hostel.hostel_management.entity.Ticket;
import com.hostel.hostel_management.entity.User;
import com.hostel.hostel_management.enums.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    long countByStatus(TicketStatus status);

    long countByUser(User user);

    long countByUserAndStatus(User user, TicketStatus status);
}
