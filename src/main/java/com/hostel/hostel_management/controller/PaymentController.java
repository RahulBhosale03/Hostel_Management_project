package com.hostel.hostel_management.controller;

import com.hostel.hostel_management.config.AuthUtil;
import com.hostel.hostel_management.dto.PaymentRequest;
import com.hostel.hostel_management.dto.PaymentResponse;
import com.hostel.hostel_management.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin
public class PaymentController {

    private final PaymentService paymentService;
    private final AuthUtil authUtil;

    public PaymentController(PaymentService paymentService, AuthUtil authUtil) {
        this.paymentService = paymentService;
        this.authUtil = authUtil;
    }

    //USER: Make payment (JWT based)
    @PostMapping
    public ResponseEntity<PaymentResponse> makePayment(
            @RequestBody PaymentRequest request) {

        Long userId = authUtil.getLoggedInUserId();

        return ResponseEntity.ok(
                paymentService.makePayment(userId, request)
        );
    }

    //USER / ADMIN: Get payment by ID
    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentResponse> getPaymentById(
            @PathVariable Long paymentId) {

        return ResponseEntity.ok(
                paymentService.getPaymentIById(paymentId)
        );
    }
}
