package com.bolsadeideas.springboot.app.infrastructure.mappers;

import com.bolsadeideas.springboot.app.domain.dto.EmployeeDto;
import com.bolsadeideas.springboot.app.domain.entities.Employee;
import java.util.List;

public interface EmployeeMapper {

    Employee convertDtoToEntity(EmployeeDto employeeDto);

    EmployeeDto convertEntityToDto(Employee employee);

    List<EmployeeDto> convertEntityListToDtoList(List<Employee> employees);


}
