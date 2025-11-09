package com.saru.movie_booking.mapper;

import com.saru.movie_booking.dto.ScreenDTO;
import com.saru.movie_booking.model.Screen;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {TheaterMapper.class})
public interface ScreenMapper {

    ScreenMapper INSTANCE = Mappers.getMapper(ScreenMapper.class);

    ScreenDTO toDTO(Screen screen);

    Screen toEntity(ScreenDTO screenDTO);
}
