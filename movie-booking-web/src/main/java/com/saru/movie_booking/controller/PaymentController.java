package com.saru.movie_booking.controller;

import com.razorpay.RazorpayException;
import com.saru.movie_booking.dto.PaymentDTO;
import com.saru.movie_booking.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create-order/{bookingId}")
    public ResponseEntity<PaymentDTO> createOrder(@PathVariable Long bookingId) throws RazorpayException {
        return ResponseEntity.ok(paymentService.createOrder(bookingId));
    }

    @PostMapping("/verify")
    public ResponseEntity<PaymentDTO> verifyPayment(
            @RequestParam String razorpayOrderId,
            @RequestParam String razorpayPaymentId,
            @RequestParam String razorpaySignature) throws RazorpayException {
        return ResponseEntity.ok(paymentService.verifyPayment(razorpayOrderId, razorpayPaymentId, razorpaySignature));
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<PaymentDTO> getPaymentByBookingId(@PathVariable Long bookingId) {
        return ResponseEntity.ok(paymentService.getPaymentByBookingId(bookingId));
    }
}

