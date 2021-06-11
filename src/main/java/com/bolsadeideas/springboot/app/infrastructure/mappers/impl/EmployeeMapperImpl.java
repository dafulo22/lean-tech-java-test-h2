package com.bolsadeideas.springboot.app.infrastructure.mappers.impl;

import com.bolsadeideas.springboot.app.domain.dto.EmployeeDto;
import com.bolsadeideas.springboot.app.domain.entities.Employee;
import com.bolsadeideas.springboot.app.infrastructure.mappers.EmployeeMapper;
import com.bolsadeideas.springboot.app.infrastructure.mappers.PersonMapper;
import com.bolsadeideas.springboot.app.infrastructure.mappers.PositionMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    private final PositionMapper positionMapper;
    private final PersonMapper personMapper;

    public EmployeeMapperImpl(PositionMapper positionMapper,
        PersonMapper personMapper) {
        this.positionMapper = positionMapper;
        this.personMapper = personMapper;
    }

    @Override
    public Employee convertDtoToEntity(EmployeeDto employeeDto) {
        return Employee.builder()
            .salary(employeeDto.getSalary())
            .position(this.positionMapper.convertDtoToEntity(employeeDto.getPosition()))
            .person(this.personMapper.convertDtoToEntity(employeeDto.getPerson())
            ).build();
    }

    @Override
    public EmployeeDto convertEntityToDto(Employee employee) {
        return EmployeeDto.builder()
            .id(employee.getId())
            .salary(employee.getSalary())
            .position(this.positionMapper.convertEntityToDto(employee.getPosition()))
            .person(this.personMapper.convertEntityToDto(employee.getPerson())).build();
    }

    @Override
    public List<EmployeeDto> convertEntityListToDtoList(List<Employee> employees) {
        return employees.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }
}
