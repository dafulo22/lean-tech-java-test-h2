package com.bolsadeideas.springboot.app.application.controllers.employee;

import static com.bolsadeideas.springboot.app.domain.constants.GeneralConstants.EMPLOYEE_URL;

import com.bolsadeideas.springboot.app.business.company.interfaces.EmployeeService;
import com.bolsadeideas.springboot.app.domain.dto.EmployeeDto;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EMPLOYEE_URL)
public class ListEmployeeController {

    private final EmployeeService employeeService;

    public ListEmployeeController(
        EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<EmployeeDto>> findAll(
        @RequestParam(name = "positionId", required = false) Long positionId,
        @RequestParam(name = "name", required = false) String name) {
        return ResponseEntity.ok().body(this.employeeService.findAll(positionId, name));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.employeeService.findById(id));
    }
}