package com.bolsadeideas.springboot.app.business.company.interfaces;

import com.bolsadeideas.springboot.app.application.commons.exception.customexceptions.StopFlowExecutionException;
import com.bolsadeideas.springboot.app.domain.dto.PositionDto;
import com.bolsadeideas.springboot.app.domain.entities.Position;
import java.util.List;

public interface PositionService {

    PositionDto create(Position position);

    PositionDto getCurrentPosition(PositionDto positionDto) throws StopFlowExecutionException;

    PositionDto findById(Long id) throws StopFlowExecutionException;

    Boolean exists(Long id);

    List<Position> findAll();

}
