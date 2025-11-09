package com.saru.movie_booking.mapper;

import com.saru.movie_booking.dto.TheaterDTO;
import com.saru.movie_booking.model.Theater;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ScreenMapper.class})
public interface TheaterMapper {
    TheaterMapper INSTANCE = Mappers.getMapper(TheaterMapper.class);

    TheaterDTO toDTO(Theater theater);

    Theater toEntity(TheaterDTO theaterDTO);
}
