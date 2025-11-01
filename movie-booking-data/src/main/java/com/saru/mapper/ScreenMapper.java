package com.saru.mapper;

import com.saru.dto.ScreenDTO;
import com.saru.model.Screen;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {TheaterMapper.class})
public interface ScreenMapper {

    ScreenMapper INSTANCE = Mappers.getMapper(ScreenMapper.class);

    ScreenDTO toDTO(Screen screen);

    Screen toEntity(ScreenDTO screenDTO);
}
