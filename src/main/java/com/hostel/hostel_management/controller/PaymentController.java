package com.hostel.hostel_management.controller;

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

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<PaymentResponse> makePayment(
            @PathVariable Long userId,
            @RequestBody PaymentRequest request){
        return ResponseEntity.ok(paymentService.makePayment(userId,request));
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentResponse> getPaymentById(@PathVariable Long paymentId){
        return ResponseEntity.ok(paymentService.getPaymentIById(paymentId));
    }
}
