package com.bolsadeideas.springboot.app.business.company.impl;

import static com.bolsadeideas.springboot.app.domain.constants.GeneralConstants.EMPLOYEE_NOT_FOUND;
import static com.bolsadeideas.springboot.app.domain.constants.UnitTestConstants.ADDRESS;
import static com.bolsadeideas.springboot.app.domain.constants.UnitTestConstants.CELLPHONE;
import static com.bolsadeideas.springboot.app.domain.constants.UnitTestConstants.CITY_NAME;
import static com.bolsadeideas.springboot.app.domain.constants.UnitTestConstants.LASTNAME;
import static com.bolsadeideas.springboot.app.domain.constants.UnitTestConstants.NAME;
import static com.bolsadeideas.springboot.app.domain.constants.UnitTestConstants.SALARY;

import com.bolsadeideas.springboot.app.application.commons.exception.customexceptions.StopFlowExecutionException;
import com.bolsadeideas.springboot.app.domain.dto.EmployeeDto;
import com.bolsadeideas.springboot.app.domain.entities.Employee;
import com.bolsadeideas.springboot.app.domain.repository.EmployeeRepository;
import com.bolsadeideas.springboot.app.infrastructure.mappers.EmployeeMapper;
import com.bolsadeideas.springboot.app.infrastructure.mappers.PositionMapper;
import com.bolsadeideas.springboot.app.infrastructure.utility.EmployeeUtility;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class EmployeeServiceImplTest {

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeMapper employeeMapper;

    @Mock
    private PositionMapper positionMapper;

    private Employee employee;
    private EmployeeDto employeeDto;

    private static final Long ID_TO_SEARCH = 1L;
    private static final Long ID_NON_EXISTENT = 11111L;

    @BeforeEach
    void setUp() {
        this.employee = EmployeeUtility.buildEmployeeEntity();
        this.employeeDto = EmployeeUtility.buildEmployeeDto();
    }

    @Test
    @DisplayName("findById test successful")
    void findById() {

        Mockito.doReturn(Optional.ofNullable(this.employee))
            .when(this.employeeRepository).findById(ID_TO_SEARCH);

        Mockito.doReturn(this.employeeDto).when(this.employeeMapper).convertEntityToDto(this.employee);

        EmployeeDto employeeDto = this.employeeService.findById(ID_TO_SEARCH);

        Assertions.assertNotNull(employeeDto);
        Assertions.assertEquals(SALARY, employeeDto.getSalary());
        Assertions.assertEquals(NAME, employeeDto.getPerson().getName());
        Assertions.assertEquals(LASTNAME, employeeDto.getPerson().getLastName());
        Assertions.assertEquals(ADDRESS, employeeDto.getPerson().getAddress());
        Assertions.assertEquals(CELLPHONE, employeeDto.getPerson().getCellphone());
        Assertions.assertEquals(CITY_NAME, employeeDto.getPerson().getCityName());
    }

    @Test
    @DisplayName("findById test error, employee not found")
    void shouldThrowException() {
        Mockito.doThrow(new StopFlowExecutionException(EMPLOYEE_NOT_FOUND + ID_NON_EXISTENT))
            .when(this.employeeRepository).findById(ID_NON_EXISTENT);

        Throwable exception = Assertions.assertThrows(StopFlowExecutionException.class, () -> {
            this.employeeService.findById(ID_NON_EXISTENT);
        });

        Assertions.assertEquals(exception.getMessage(), EMPLOYEE_NOT_FOUND + ID_NON_EXISTENT);
    }
}