package com.saru.mapper;

import com.saru.dto.BookingSeatDTO;
import com.saru.model.BookingSeat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {SeatMapper.class, BookingMapper.class})
public interface BookingSeatMapper {

    BookingSeatMapper INSTANCE = Mappers.getMapper(BookingSeatMapper.class);

    BookingSeatDTO toDTO(BookingSeat bookingSeat);

    BookingSeat toEntity(BookingSeatDTO bookingSeatDTO);
}
