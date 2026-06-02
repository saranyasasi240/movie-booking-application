package com.saru.movie_booking.service;

import com.saru.movie_booking.model.Booking;
import com.saru.movie_booking.model.BookingSeat;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${mail.from}")
    private String fromEmail;

    public void sendBookingConfirmation(Booking booking, List<BookingSeat> bookingSeats) {
        String seatNumbers = bookingSeats.stream()
                .map(bs -> bs.getSeat().getSeatNumber())
                .collect(Collectors.joining(", "));

        String subject = "Booking Confirmation - Booking ID: " + booking.getId();
        String body = "Dear " + booking.getUser().getName() + ",\n\n"
                + "Your booking has been confirmed!\n\n"
                + "Booking Details:\n"
                + "Booking ID   : " + booking.getId() + "\n"
                + "Show         : " + booking.getShows().getId() + "\n"
                + "Seats        : " + seatNumbers + "\n"
                + "Total Price  : Rs. " + booking.getTotalPrice() + "\n"
                + "Booking Time : " + booking.getBookingTime() + "\n"
                + "Status       : " + booking.getStatus() + "\n\n"
                + "Thank you for booking with us!\n"
                + "Movie Booking Team";

        sendEmail(booking.getUser().getEmail(), subject, body);
    }

    public void sendCancellationEmail(Booking booking, List<BookingSeat> bookingSeats) {
        String seatNumbers = bookingSeats.stream()
                .map(bs -> bs.getSeat().getSeatNumber())
                .collect(Collectors.joining(", "));

        String subject = "Booking Cancellation - Booking ID: " + booking.getId();
        String body = "Dear " + booking.getUser().getName() + ",\n\n"
                + "Your booking has been cancelled.\n\n"
                + "Cancelled Booking Details:\n"
                + "Booking ID   : " + booking.getId() + "\n"
                + "Show         : " + booking.getShows().getId() + "\n"
                + "Seats        : " + seatNumbers + "\n"
                + "Total Price  : Rs. " + booking.getTotalPrice() + "\n"
                + "Status       : " + booking.getStatus() + "\n\n"
                + "We hope to see you again!\n"
                + "Movie Booking Team";

        sendEmail(booking.getUser().getEmail(), subject, body);
    }

    private void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}
