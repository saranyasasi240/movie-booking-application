package com.saru.service;

import com.saru.model.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    Booking addBooking(Booking booking);

    List<Booking> getAllBooking();

    Optional<Booking> getBookingById(Long id);

    void deleteBooking(Long id);
}
