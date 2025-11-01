package com.saru.mapper;


import com.saru.dto.BookingDTO;
import com.saru.model.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ShowMapper.class, UserMapper.class})
public interface BookingMapper {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    BookingDTO toDTO(Booking booking);
    Booking toEntity(BookingDTO bookingDTO);
}
