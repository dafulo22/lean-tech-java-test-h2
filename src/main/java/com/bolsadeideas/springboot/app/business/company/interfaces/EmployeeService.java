package com.bolsadeideas.springboot.app.business.company.interfaces;

import com.bolsadeideas.springboot.app.application.commons.exception.customexceptions.StopFlowExecutionException;
import com.bolsadeideas.springboot.app.domain.dto.EmployeeDto;
import java.util.List;

public interface EmployeeService {

    EmployeeDto create(EmployeeDto employee) throws StopFlowExecutionException;

    EmployeeDto update(Long id, Integer salary) throws StopFlowExecutionException;

    void delete(Long id) throws StopFlowExecutionException;

    EmployeeDto findById(Long id) throws StopFlowExecutionException;

    List<EmployeeDto> findAll(Long positionId, String name) throws StopFlowExecutionException;

    Boolean isAnEmployee(Long personId);

}