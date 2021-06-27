package com.bolsadeideas.springboot.app.infrastructure.utility;

import static com.bolsadeideas.springboot.app.domain.constants.UnitTestConstants.ID;
import static com.bolsadeideas.springboot.app.domain.constants.UnitTestConstants.SALARY;

import com.bolsadeideas.springboot.app.domain.dto.EmployeeDto;
import com.bolsadeideas.springboot.app.domain.entities.Employee;

public class EmployeeUtility {

    private EmployeeUtility() {

    }

    public static EmployeeDto buildEmployeeDto() {
        return EmployeeDto.builder()
            .id(ID)
            .person(PersonUtility.buildPersonDto())
            .position(PositionUtility.buildPositionDto())
            .salary(SALARY)
            .build();
    }

    public static Employee buildEmployeeEntity() {
        return Employee.builder()
            .id(ID)
            .person(PersonUtility.buildPersonEntity())
            .position(PositionUtility.buildPositionEntity())
            .salary(SALARY)
            .build();
    }
}
