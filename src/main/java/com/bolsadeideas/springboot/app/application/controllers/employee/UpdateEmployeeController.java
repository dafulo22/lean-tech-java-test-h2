package com.bolsadeideas.springboot.app.application.controllers.employee;

import static com.bolsadeideas.springboot.app.domain.constants.GeneralConstants.EMPLOYEE_URL;

import com.bolsadeideas.springboot.app.business.company.interfaces.EmployeeService;
import com.bolsadeideas.springboot.app.domain.dto.EmployeeDto;
import com.bolsadeideas.springboot.app.domain.dto.UpdateEmployeeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EMPLOYEE_URL)
public class UpdateEmployeeController {

    private final EmployeeService employeeService;

    public UpdateEmployeeController(
        EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EmployeeDto> update(@PathVariable Long id, @RequestBody UpdateEmployeeDto employeeDto) {
        EmployeeDto updatedEmployee = this.employeeService.update(id, employeeDto.getSalary());
        return ResponseEntity.ok().body(updatedEmployee);
    }
}