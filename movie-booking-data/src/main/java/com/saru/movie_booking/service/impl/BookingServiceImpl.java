package com.saru.movie_booking.service.impl;

import com.saru.movie_booking.dto.BookingDTO;
import com.saru.movie_booking.mapper.BookingMapper;
import com.saru.movie_booking.model.Booking;
import com.saru.movie_booking.model.BookingSeat;
import com.saru.movie_booking.model.Seat;
import com.saru.movie_booking.model.TicketPrice;
import com.saru.movie_booking.repository.*;
import com.saru.movie_booking.service.BookingService;
import com.saru.movie_booking.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final UserRepository userRepository;
    private final ShowRepository showRepository;
    private final SeatRepository seatRepository;
    private final TicketPriceRepository ticketPriceRepository;
    private final BookingSeatRepository bookingSeatRepository;
    private final EmailService emailService;

    @Override
    public Optional<BookingDTO> getBookingById(Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        BookingDTO bookingDTO = bookingMapper.toDTO(booking.orElse(null));
        return Optional.ofNullable(bookingDTO);
    }

    @Override
    public BookingDTO addBooking(BookingDTO bookingDTO) {
        // validate seats availability
        List<Seat> seats = seatRepository.findAllById(bookingDTO.getSeatIds());
        for (Seat seat : seats) {
            if ("BOOKED".equals(seat.getStatus())) {
                throw new RuntimeException("Seat " + seat.getSeatNumber() + " is already booked..!");
            }
        }
        // calculate total price
        double totalPrice = 0;
        for (Seat seat : seats) {
            TicketPrice ticketPrice = ticketPriceRepository
                    .findByShowIdAndSeatId(bookingDTO.getShowId(), seat.getId())
                    .orElseThrow(() -> new RuntimeException("Ticket price not found..!"));
            totalPrice += ticketPrice.getPrice();
        }
        // create booking
        Booking booking = bookingMapper.toEntity(bookingDTO);
        booking.setUser(userRepository.findById(bookingDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found..!")));
        booking.setShows(showRepository.findById(bookingDTO.getShowId())
                .orElseThrow(() -> new RuntimeException("Show not found..!")));
        booking.setBookingTime(LocalDateTime.now());
        booking.setStatus("CONFIRMED");
        booking.setTotalPrice(totalPrice);
        Booking savedBooking = bookingRepository.save(booking);
        // mark seats as BOOKED
        seats.forEach(seat -> seat.setStatus("BOOKED"));
        seatRepository.saveAll(seats);

        // Store booked seats in BookingSeat table
        List<BookingSeat> bookingSeats = new ArrayList<>();
        for (Seat seat : seats) {
            BookingSeat bookingSeat = new BookingSeat();
            bookingSeat.setBooking(savedBooking);
            bookingSeat.setSeat(seat);
            bookingSeat.setStatus("BOOKED");
            bookingSeats.add(bookingSeat);
        }
        bookingSeatRepository.saveAll(bookingSeats);

        // send booking confirmation email
        emailService.sendBookingConfirmation(savedBooking, bookingSeats);

        BookingDTO savedDTO = bookingMapper.toDTO(savedBooking);
        savedDTO.setSeatIds(bookingDTO.getSeatIds());
        return savedDTO;
    }

    @Override
    public BookingDTO cancelBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found..!"));
        booking.setStatus("CANCELLED");
        // release seats
        List<BookingSeat> bookingSeatList = bookingSeatRepository.findByBooking_Id(id);
        List<Seat> bookedSeats = new ArrayList<>();
        for (BookingSeat bookingSeat : bookingSeatList) {
            bookingSeat.setStatus("CANCELLED");
            Seat seat = bookingSeat.getSeat();
            seat.setStatus("AVAILABLE");
            bookedSeats.add(seat);
        }
        bookingSeatRepository.saveAll(bookingSeatList);
        seatRepository.saveAll(bookedSeats);

        bookingRepository.save(booking);

        // send cancellation email
        emailService.sendCancellationEmail(booking, bookingSeatList);

        return bookingMapper.toDTO(booking);
    }

    @Override
    public List<BookingDTO> getAllBooking() {
        List<BookingDTO> allBookingDTO = new ArrayList<>();
        for (Booking booking : bookingRepository.findAll()) {
            allBookingDTO.add(bookingMapper.toDTO(booking));
        }
        return allBookingDTO;
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}