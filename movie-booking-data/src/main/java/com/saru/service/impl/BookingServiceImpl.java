package com.saru.service.impl;

import com.saru.model.Booking;
import com.saru.repository.BookingRepository;
import com.saru.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking addBooking(Booking booking){
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBooking(){
        return bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> getBookingById(Long id){
        return bookingRepository.findById(id);
    }

    @Override
    public void deleteBooking(Long id){
        bookingRepository.deleteById(id);
    }
}
