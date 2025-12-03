package com.saru.movie_booking.mapper;

import com.saru.movie_booking.dto.SeatDTO;
import com.saru.movie_booking.model.Seat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ScreenMapper.class})
public interface SeatMapper {
//    SeatMapper INSTANCE = Mappers.getMapper(SeatMapper.class);

    SeatDTO toDTO(Seat seat);

    Seat toEntity(SeatDTO seatDTO);
}
