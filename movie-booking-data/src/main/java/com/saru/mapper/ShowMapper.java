package com.saru.mapper;

import com.saru.dto.ShowDTO;
import com.saru.model.Show;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {MovieMapper.class, ScreenMapper.class})
public interface ShowMapper {
    ShowMapper INSTANCE = Mappers.getMapper(ShowMapper.class);

    ShowDTO toDTO(Show show);

    Show toEntity(ShowDTO showDTO);
}
