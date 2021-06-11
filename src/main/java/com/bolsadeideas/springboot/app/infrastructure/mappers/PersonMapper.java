package com.bolsadeideas.springboot.app.infrastructure.mappers;

import com.bolsadeideas.springboot.app.domain.dto.PersonDto;
import com.bolsadeideas.springboot.app.domain.entities.Person;
import java.util.List;

public interface PersonMapper {

    Person convertDtoToEntity(PersonDto personDto);

    PersonDto convertEntityToDto(Person person);

    List<Person> convertDtoListToEntityList(List<PersonDto> personDto);

}
