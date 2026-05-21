package com.saru.movie_booking.mapper;

import com.saru.movie_booking.dto.SeatDTO;
import com.saru.movie_booking.model.Seat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ScreenMapper.class})
public interface SeatMapper {

    SeatMapper INSTANCE = Mappers.getMapper(SeatMapper.class);

    @Mapping(source = "screen.id", target = "screenId")
    SeatDTO toDTO(Seat seat);

    @Mapping(target = "screen", ignore = true)
    Seat toEntity(SeatDTO seatDTO);
}
