package com.bolsadeideas.springboot.app.infrastructure.utility;

import static com.bolsadeideas.springboot.app.domain.constants.UnitTestConstants.ID;
import static com.bolsadeideas.springboot.app.domain.constants.UnitTestConstants.POSITION_NAME;

import com.bolsadeideas.springboot.app.domain.dto.PositionDto;
import com.bolsadeideas.springboot.app.domain.entities.Position;
import java.util.Collections;

public class PositionUtility {

    private PositionUtility() {

    }

    public static PositionDto buildPositionDto() {
        return PositionDto
            .builder()
            .id(ID)
            .name(POSITION_NAME)
            .build();
    }

    public static Position buildPositionEntity() {
        return Position
            .builder()
            .id(ID)
            .name(POSITION_NAME)
            .employees(Collections.emptyList())
            .build();
    }
}
