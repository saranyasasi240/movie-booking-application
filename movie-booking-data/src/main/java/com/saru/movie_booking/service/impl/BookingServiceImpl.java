package com.saru.movie_booking.service.impl;

import com.saru.movie_booking.dto.BookingDTO;
import com.saru.movie_booking.mapper.BookingMapper;
import com.saru.movie_booking.model.Booking;
import com.saru.movie_booking.repository.BookingRepository;
import com.saru.movie_booking.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    public BookingServiceImpl(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    @Override
    public BookingDTO addBooking(BookingDTO bookingDTO) {
        Booking booking = bookingMapper.toEntity(bookingDTO);
        Booking savedBooking = bookingRepository.save(booking);
        return bookingMapper.toDTO(savedBooking);
    }

    @Override
    public List<BookingDTO> getAllBooking() {
        List<BookingDTO> allBookingDTO = new ArrayList<>();
        List<Booking> allBookings = bookingRepository.findAll();
        for (Booking booking : allBookings) {
            allBookingDTO.add(bookingMapper.toDTO(booking));
        }
        return allBookingDTO;
    }

    @Override
    public Optional<BookingDTO> getBookingById(Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        BookingDTO bookingDTO = bookingMapper.toDTO(booking.orElse(null));
        return Optional.ofNullable(bookingDTO);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
