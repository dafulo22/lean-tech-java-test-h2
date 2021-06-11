package com.bolsadeideas.springboot.app.application.controllers.employee;

import static com.bolsadeideas.springboot.app.domain.constants.GeneralConstants.EMPLOYEE_URL;

import com.bolsadeideas.springboot.app.business.company.interfaces.EmployeeService;
import com.bolsadeideas.springboot.app.domain.dto.EmployeeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EMPLOYEE_URL)
public class CreateEmployeeController {

    private final EmployeeService employeeService;

    public CreateEmployeeController(
        EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/")
    public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto employee) {
        EmployeeDto savedEmployee = this.employeeService.create(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

}