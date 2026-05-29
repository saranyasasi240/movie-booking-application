package com.saru.movie_booking.service;

import com.saru.movie_booking.dto.BookingDTO;

import java.util.List;
import java.util.Optional;

public interface BookingService {

    BookingDTO addBooking(BookingDTO bookingDTO);

    List<BookingDTO> getAllBooking();

    Optional<BookingDTO> getBookingById(Long id);

    void deleteBooking(Long id);

    BookingDTO cancelBooking(Long id);
}
