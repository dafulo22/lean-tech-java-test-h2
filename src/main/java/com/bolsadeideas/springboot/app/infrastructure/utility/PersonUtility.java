package com.bolsadeideas.springboot.app.infrastructure.utility;

import static com.bolsadeideas.springboot.app.domain.constants.UnitTestConstants.ADDRESS;
import static com.bolsadeideas.springboot.app.domain.constants.UnitTestConstants.CELLPHONE;
import static com.bolsadeideas.springboot.app.domain.constants.UnitTestConstants.CITY_NAME;
import static com.bolsadeideas.springboot.app.domain.constants.UnitTestConstants.ID;
import static com.bolsadeideas.springboot.app.domain.constants.UnitTestConstants.LASTNAME;
import static com.bolsadeideas.springboot.app.domain.constants.UnitTestConstants.NAME;

import com.bolsadeideas.springboot.app.domain.dto.PersonDto;
import com.bolsadeideas.springboot.app.domain.entities.Person;

public class PersonUtility {

    private PersonUtility() {

    }

    public static PersonDto buildPersonDto() {
        return PersonDto.builder()
            .address(ADDRESS)
            .cellphone(CELLPHONE)
            .name(NAME)
            .lastName(LASTNAME)
            .cityName(CITY_NAME)
            .id(ID)
            .build();
    }

    public static Person buildPersonEntity() {
        return Person.builder()
            .address(ADDRESS)
            .cellphone(CELLPHONE)
            .name(NAME)
            .lastName(LASTNAME)
            .cityName(CITY_NAME)
            .id(ID)
            .build();
    }
}
