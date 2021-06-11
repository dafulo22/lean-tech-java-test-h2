package com.bolsadeideas.springboot.app.business.company.impl;

import static com.bolsadeideas.springboot.app.domain.constants.GeneralConstants.EMPLOYEE_NOT_FOUND;
import static com.bolsadeideas.springboot.app.domain.constants.GeneralConstants.ERROR_MESSAGE;
import static com.bolsadeideas.springboot.app.domain.constants.GeneralConstants.PERSON_IS_ALREADY_AN_EMPLOYEE;
import static com.bolsadeideas.springboot.app.domain.constants.GeneralConstants.REQUIRED_SALARY;

import com.bolsadeideas.springboot.app.application.commons.exception.customexceptions.StopFlowExecutionException;
import com.bolsadeideas.springboot.app.business.company.interfaces.EmployeeService;
import com.bolsadeideas.springboot.app.business.company.interfaces.PersonService;
import com.bolsadeideas.springboot.app.business.company.interfaces.PositionService;
import com.bolsadeideas.springboot.app.domain.dto.EmployeeDto;
import com.bolsadeideas.springboot.app.domain.dto.PersonDto;
import com.bolsadeideas.springboot.app.domain.dto.PositionDto;
import com.bolsadeideas.springboot.app.domain.entities.Employee;
import com.bolsadeideas.springboot.app.domain.repository.EmployeeRepository;
import com.bolsadeideas.springboot.app.infrastructure.mappers.EmployeeMapper;
import com.bolsadeideas.springboot.app.infrastructure.mappers.PositionMapper;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final PositionMapper positionMapper;
    private final EmployeeRepository employeeRepository;
    private final PositionService positionService;
    private final PersonService personService;

    public EmployeeServiceImpl(EmployeeMapper employeeMapper,
        PositionMapper positionMapper,
        EmployeeRepository employeeRepository,
        PositionService positionService,
        PersonService personService) {
        this.employeeMapper = employeeMapper;
        this.positionMapper = positionMapper;
        this.employeeRepository = employeeRepository;
        this.positionService = positionService;
        this.personService = personService;
    }

    @Override
    @Transactional(rollbackFor = StopFlowExecutionException.class)
    public EmployeeDto create(EmployeeDto employeeDto) {

        if (Boolean.TRUE.equals(this.isAnEmployee(employeeDto.getPerson().getId()))) {
            throw new StopFlowExecutionException(PERSON_IS_ALREADY_AN_EMPLOYEE);
        }

        this.validateSalary(employeeDto.getSalary());

        PersonDto person = this.personService.getCurrentPerson(employeeDto.getPerson());

        PositionDto position = this.positionService.getCurrentPosition(employeeDto.getPosition());

        employeeDto.setPerson(person);
        employeeDto.setPosition(position);

        Employee employee = this.employeeMapper.convertDtoToEntity(employeeDto);
        try {
            return this.employeeMapper.convertEntityToDto(this.employeeRepository.save(employee));
        } catch (Exception exception) {
            throw new StopFlowExecutionException(ERROR_MESSAGE + exception.getMessage());
        }
    }

    @Override
    public EmployeeDto update(Long id, Integer salary) throws StopFlowExecutionException {

        Employee currentEmployee = this.getCurrentEmployee(id);

        this.validateSalary(salary);

        currentEmployee.setSalary(salary);

        return this.employeeMapper.convertEntityToDto(this.employeeRepository.saveAndFlush(currentEmployee));

    }

    @Override
    public void delete(Long id) throws StopFlowExecutionException {
        if (Boolean.FALSE.equals(this.employeeRepository.existsById(id))) {
            throw new StopFlowExecutionException(EMPLOYEE_NOT_FOUND + id);
        }
        this.employeeRepository.findById(id).ifPresent(this.employeeRepository::delete);
    }

    @Override
    public EmployeeDto findById(Long id) throws StopFlowExecutionException {
        return this.employeeMapper.convertEntityToDto(this.getCurrentEmployee(id));
    }

    @Override
    public List<EmployeeDto> findAll(Long positionId, String name) {
        List<Employee> employeeList;

        if (Objects.nonNull(positionId) && Objects.nonNull(name)) {
            PositionDto position = this.positionService.findById(positionId);
            employeeList = this.employeeRepository
                .findByPositionAndPersonNameIgnoreCaseContaining(this.positionMapper.convertDtoToEntity(position),
                    name);
        } else if (!Objects.nonNull(positionId) && Objects.nonNull(name)) {
            employeeList = this.employeeRepository.findByPersonNameIgnoreCaseContaining(name);
        } else if (Objects.nonNull(positionId)) {
            PositionDto position = this.positionService.findById(positionId);
            employeeList = this.employeeRepository.findByPosition(this.positionMapper.convertDtoToEntity(position));
        } else {
            employeeList = StreamSupport
                .stream(this.employeeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        }

        return this.employeeMapper.convertEntityListToDtoList(employeeList);
    }

    @Override
    public Boolean isAnEmployee(Long personId) {
        return this.employeeRepository.existsByPersonId(personId);
    }

    private Employee getCurrentEmployee(Long id) {
        return this.employeeRepository.findById(id)
            .orElseThrow(() -> new StopFlowExecutionException(EMPLOYEE_NOT_FOUND + id));
    }

    private void validateSalary(Integer salary) {
        if (Objects.isNull(salary) || salary <= 0) {
            throw new StopFlowExecutionException(REQUIRED_SALARY);
        }
    }

}
