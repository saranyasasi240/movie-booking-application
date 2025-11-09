package com.saru.movie_booking.mapper;


import com.saru.movie_booking.dto.BookingDTO;
import com.saru.movie_booking.model.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ShowMapper.class, UserMapper.class})
public interface BookingMapper {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    BookingDTO toDTO(Booking booking);
    Booking toEntity(BookingDTO bookingDTO);
}
