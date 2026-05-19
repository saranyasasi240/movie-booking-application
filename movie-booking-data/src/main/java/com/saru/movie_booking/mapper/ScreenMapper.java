package com.saru.movie_booking.mapper;

import com.saru.movie_booking.dto.ScreenDTO;
import com.saru.movie_booking.model.Screen;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ScreenMapper {

    ScreenMapper INSTANCE = Mappers.getMapper(ScreenMapper.class);

    @Mapping(source = "theater.id", target = "theaterId")
    ScreenDTO toDTO(Screen screen);

    @Mapping(target = "theater", ignore = true)
    Screen toEntity(ScreenDTO screenDTO);
}
