package com.saru.movie_booking.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentDTO {
    private long id;
    private Long bookingId;
    private String razorpayOrderId;
    private String razorpayPaymentId;
    private double amount;
    private String status;
    private LocalDateTime createdAt;
}

