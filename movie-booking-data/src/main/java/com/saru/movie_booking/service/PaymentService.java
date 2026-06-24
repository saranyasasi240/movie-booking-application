package com.saru.movie_booking.service;

import com.razorpay.RazorpayException;
import com.saru.movie_booking.dto.PaymentDTO;

public interface PaymentService {
    PaymentDTO createOrder(Long bookingId) throws RazorpayException;
    PaymentDTO verifyPayment(String razorpayOrderId, String razorpayPaymentId, String razorpaySignature) throws RazorpayException;
    PaymentDTO getPaymentByBookingId(Long bookingId);
}

