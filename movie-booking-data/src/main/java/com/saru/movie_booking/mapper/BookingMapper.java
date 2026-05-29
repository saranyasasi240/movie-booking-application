package com.saru.movie_booking.mapper;


import com.saru.movie_booking.dto.BookingDTO;
import com.saru.movie_booking.model.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "shows.id", target = "showId")
    @Mapping(target = "seatIds", ignore = true)
    BookingDTO toDTO(Booking booking);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "shows", ignore = true)
    Booking toEntity(BookingDTO bookingDTO);
}
