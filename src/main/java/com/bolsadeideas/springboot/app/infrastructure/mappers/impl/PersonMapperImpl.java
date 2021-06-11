package com.bolsadeideas.springboot.app.infrastructure.mappers.impl;

import com.bolsadeideas.springboot.app.domain.dto.PersonDto;
import com.bolsadeideas.springboot.app.domain.entities.Person;
import com.bolsadeideas.springboot.app.infrastructure.mappers.PersonMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person convertDtoToEntity(PersonDto personDto) {
        return Person.builder()
            .address(personDto.getAddress())
            .cellphone(personDto.getCellphone())
            .name(personDto.getName())
            .lastName(personDto.getLastName())
            .cityName(personDto.getCityName())
            .id(personDto.getId())
            .build();
    }

    @Override
    public PersonDto convertEntityToDto(Person person) {
        return PersonDto.builder()
            .address(person.getAddress())
            .cellphone(person.getCellphone())
            .name(person.getName())
            .lastName(person.getLastName())
            .cityName(person.getCityName())
            .id(person.getId())
            .build();
    }

    @Override
    public List<Person> convertDtoListToEntityList(List<PersonDto> personDtos) {
        return personDtos.stream().map(this::convertDtoToEntity).collect(Collectors.toList());
    }
}
