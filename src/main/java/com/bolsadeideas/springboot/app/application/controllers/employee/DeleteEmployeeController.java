package com.bolsadeideas.springboot.app.application.controllers.employee;

import static com.bolsadeideas.springboot.app.domain.constants.GeneralConstants.DELETE_SUCCESSFULLY;
import static com.bolsadeideas.springboot.app.domain.constants.GeneralConstants.EMPLOYEE_URL;

import com.bolsadeideas.springboot.app.business.company.interfaces.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EMPLOYEE_URL)
public class DeleteEmployeeController {

    private final EmployeeService employeeService;

    public DeleteEmployeeController(
        EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        this.employeeService.delete(id);
        return new ResponseEntity<>(DELETE_SUCCESSFULLY, HttpStatus.OK);
    }
}