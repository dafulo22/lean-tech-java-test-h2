package com.bolsadeideas.springboot.app.infrastructure.mappers;

import com.bolsadeideas.springboot.app.domain.dto.PositionDto;
import com.bolsadeideas.springboot.app.domain.entities.Position;
import java.util.List;

public interface PositionMapper {

    Position convertDtoToEntity(PositionDto positionDto);

    PositionDto convertEntityToDto(Position position);

    List<PositionDto> convertEntityListToDtoList(List<Position> positions);

}
