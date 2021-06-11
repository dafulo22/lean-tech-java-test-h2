package com.bolsadeideas.springboot.app.infrastructure.mappers.impl;

import com.bolsadeideas.springboot.app.domain.dto.PositionDto;
import com.bolsadeideas.springboot.app.domain.entities.Position;
import com.bolsadeideas.springboot.app.infrastructure.mappers.PositionMapper;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PositionMapperImpl implements PositionMapper {

    @Override
    public Position convertDtoToEntity(PositionDto positionDto) {
        return Position
            .builder()
            .id(positionDto.getId())
            .name(positionDto.getName())
            .build();
    }

    @Override
    public PositionDto convertEntityToDto(Position position) {
        return PositionDto
            .builder()
            .id(position.getId())
            .name(position.getName())
            .build();
    }

    @Override
    public List<PositionDto> convertEntityListToDtoList(List<Position> positions) {
        return null;
    }
}
