package com.bolsadeideas.springboot.app.business.company.impl;

import static com.bolsadeideas.springboot.app.domain.constants.GeneralConstants.POSITION_NOT_FOUND;
import static com.bolsadeideas.springboot.app.domain.constants.GeneralConstants.REQUIRED_FILES;

import com.bolsadeideas.springboot.app.application.commons.exception.customexceptions.StopFlowExecutionException;
import com.bolsadeideas.springboot.app.business.company.interfaces.PositionService;
import com.bolsadeideas.springboot.app.domain.dto.PositionDto;
import com.bolsadeideas.springboot.app.domain.entities.Position;
import com.bolsadeideas.springboot.app.domain.repository.PositionRepository;
import com.bolsadeideas.springboot.app.infrastructure.mappers.PositionMapper;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;
    private final PositionMapper positionMapper;

    public PositionServiceImpl(PositionRepository positionRepository,
        PositionMapper positionMapper) {
        this.positionRepository = positionRepository;
        this.positionMapper = positionMapper;
    }

    @Override
    public PositionDto create(Position position) {
        return this.positionMapper.convertEntityToDto((this.positionRepository.saveAndFlush(position)));
    }

    @Override
    public PositionDto getCurrentPosition(PositionDto positionDto) throws StopFlowExecutionException {

        if (Boolean.TRUE.equals(this.isInformationIncomplete(positionDto))) {
            throw new StopFlowExecutionException(REQUIRED_FILES);
        }

        Boolean positionExistsByName = this.existsByName(positionDto.getName());

        if (Boolean.TRUE.equals(positionExistsByName)) {
            return this.findByName(positionDto.getName());
        }

        if (Boolean.TRUE.equals(Objects.nonNull(positionDto.getId()))) {
            Boolean positionExists = this.exists(positionDto.getId());
            if (Boolean.TRUE.equals(positionExists)) {
                return this.findById(positionDto.getId());
            }
        }
        return this.create(this.positionMapper.convertDtoToEntity(positionDto));
    }

    @Override
    public PositionDto findById(Long id) throws StopFlowExecutionException {
        return this.positionMapper.convertEntityToDto(this.positionRepository.findById(id)
            .orElseThrow(() -> new StopFlowExecutionException(POSITION_NOT_FOUND + id)));
    }

    @Override
    public Boolean exists(Long id) {
        return this.positionRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Position> findAll() {
        return this.positionRepository.findAll();
    }

    private Boolean existsByName(String name) {
        return this.positionRepository.existsByNameIgnoreCaseContaining(name);
    }

    private PositionDto findByName(String name) {
        return this.positionMapper.convertEntityToDto(this.positionRepository.findByNameIgnoreCaseContaining(name));
    }

    private Boolean isInformationIncomplete(PositionDto positionDto) {
        return Objects.isNull(positionDto) || Objects.isNull(positionDto.getName());
    }
}
