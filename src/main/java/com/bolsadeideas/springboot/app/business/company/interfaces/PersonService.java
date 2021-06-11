package com.bolsadeideas.springboot.app.business.company.interfaces;

import com.bolsadeideas.springboot.app.application.commons.exception.customexceptions.StopFlowExecutionException;
import com.bolsadeideas.springboot.app.domain.dto.PersonDto;
import com.bolsadeideas.springboot.app.domain.entities.Person;

public interface PersonService {

    PersonDto create(Person person);

    PersonDto getCurrentPerson(PersonDto personDto) throws StopFlowExecutionException;

    PersonDto findById(Long id) throws StopFlowExecutionException;

    Boolean exists(Long id);

}
