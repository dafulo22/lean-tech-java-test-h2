package com.bolsadeideas.springboot.app.business.company.impl;

import static com.bolsadeideas.springboot.app.domain.constants.GeneralConstants.PERSON_NOT_FOUND;
import static com.bolsadeideas.springboot.app.domain.constants.GeneralConstants.REQUIRED_FILES;

import com.bolsadeideas.springboot.app.application.commons.exception.customexceptions.StopFlowExecutionException;
import com.bolsadeideas.springboot.app.business.company.interfaces.PersonService;
import com.bolsadeideas.springboot.app.domain.dto.PersonDto;
import com.bolsadeideas.springboot.app.domain.entities.Person;
import com.bolsadeideas.springboot.app.domain.repository.PersonRepository;
import com.bolsadeideas.springboot.app.infrastructure.mappers.PersonMapper;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonServiceImpl(PersonRepository personRepository,
        PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public PersonDto create(Person person) {
        return this.personMapper.convertEntityToDto(this.personRepository.saveAndFlush(person));
    }

    @Override
    public PersonDto getCurrentPerson(PersonDto personDto) throws StopFlowExecutionException {

        if (Boolean.TRUE.equals(this.isInformationIncomplete(personDto))) {
            throw new StopFlowExecutionException(REQUIRED_FILES);
        }

        if (Boolean.TRUE.equals(Objects.nonNull(personDto.getId()))) {
            Boolean personExists = this.exists(personDto.getId());
            if (Boolean.TRUE.equals(personExists)) {
                return this.findById(personDto.getId());
            }
        }
        return this.create(this.personMapper.convertDtoToEntity(personDto));
    }

    @Override
    public PersonDto findById(Long id) throws StopFlowExecutionException {
        return this.personMapper.convertEntityToDto(this.personRepository.findById(id)
            .orElseThrow(() -> new StopFlowExecutionException(PERSON_NOT_FOUND + id)));
    }

    @Override
    public Boolean exists(Long id) {
        return this.personRepository.existsById(id);
    }

    private Boolean isInformationIncomplete(PersonDto personDto) {
        return Objects.isNull(personDto) || Objects.isNull(personDto.getAddress())
            || Objects.isNull(personDto.getCellphone()) || Objects.isNull(personDto.getName())
            || Objects.isNull(personDto.getCityName()) || Objects.isNull(personDto.getLastName());
    }
}
