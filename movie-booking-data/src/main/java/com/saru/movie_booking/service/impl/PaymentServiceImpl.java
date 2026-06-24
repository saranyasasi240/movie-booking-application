package com.saru.movie_booking.service.impl;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;
import com.saru.movie_booking.dto.PaymentDTO;
import com.saru.movie_booking.model.Booking;
import com.saru.movie_booking.model.Payment;
import com.saru.movie_booking.repository.BookingRepository;
import com.saru.movie_booking.repository.PaymentRepository;
import com.saru.movie_booking.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final BookingRepository bookingRepository;

    @Value("${razorpay.key.id}")
    private String keyId;

    @Value("${razorpay.key.secret}")
    private String keySecret;

    @Override
    public PaymentDTO createOrder(Long bookingId) throws RazorpayException {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found..!"));

        RazorpayClient razorpayClient = new RazorpayClient(keyId, keySecret);
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", (int)(booking.getTotalPrice() * 100)); // in paise
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "booking_" + bookingId);

        Order order = razorpayClient.orders.create(orderRequest);

        Payment payment = new Payment();
        payment.setBooking(booking);
        payment.setRazorpayOrderId(order.get("id"));
        payment.setAmount(booking.getTotalPrice());
        payment.setStatus("PENDING");
        payment.setCreatedAt(LocalDateTime.now());
        Payment savedPayment = paymentRepository.save(payment);

        return toDTO(savedPayment);
    }

    @Override
    public PaymentDTO verifyPayment(String razorpayOrderId, String razorpayPaymentId, String razorpaySignature) throws RazorpayException {
        Payment payment = paymentRepository.findByRazorpayOrderId(razorpayOrderId)
                .orElseThrow(() -> new RuntimeException("Payment not found..!"));
        try {
            String generatedSignature = Utils.getHash(razorpayOrderId + "|" + razorpayPaymentId, keySecret);
            if (generatedSignature.equals(razorpaySignature)) {
                payment.setRazorpayPaymentId(razorpayPaymentId);
                payment.setStatus("SUCCESS");
            } else {
                payment.setStatus("FAILED");
            }
        } catch (Exception e) {
            payment.setStatus("FAILED");
        }
        return toDTO(paymentRepository.save(payment));
    }

    @Override
    public PaymentDTO getPaymentByBookingId(Long bookingId) {
        Payment payment = paymentRepository.findByBookingId(bookingId)
                .orElseThrow(() -> new RuntimeException("Payment not found..!"));
        return toDTO(payment);
    }

    private PaymentDTO toDTO(Payment payment) {
        PaymentDTO dto = new PaymentDTO();
        dto.setId(payment.getId());
        dto.setBookingId(payment.getBooking().getId());
        dto.setRazorpayOrderId(payment.getRazorpayOrderId());
        dto.setRazorpayPaymentId(payment.getRazorpayPaymentId());
        dto.setAmount(payment.getAmount());
        dto.setStatus(payment.getStatus());
        dto.setCreatedAt(payment.getCreatedAt());
        return dto;
    }
}

