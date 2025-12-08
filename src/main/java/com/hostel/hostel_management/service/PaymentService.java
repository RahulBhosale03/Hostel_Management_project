package com.hostel.hostel_management.service;

import com.hostel.hostel_management.dto.PaymentRequest;
import com.hostel.hostel_management.dto.PaymentResponse;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

    PaymentResponse makePayment(Long userId , PaymentRequest request);

    PaymentResponse getPaymentIById(Long paymentId);
}
