package com.bolsadeideas.springboot.app.domain.constants;

public class GeneralConstants {

    public static final String EMPLOYEE_URL = "/employee";
    public static final String POSITION_URL = "/position";
    // ERROR MESSAGES
    public static final String PERSON_IS_ALREADY_AN_EMPLOYEE = "** This person is already an employee:: ";
    public static final String ERROR_MESSAGE = "** An error has ocurred:: ";
    public static final String EMPLOYEE_NOT_FOUND = "** Employee not found for id :: ";
    public static final String PERSON_NOT_FOUND = "** Person not found for id :: ";
    public static final String POSITION_NOT_FOUND = "** Position not found for id :: ";
    public static final String REQUIRED_FILES = "** Required fields are empty :: ";
    public static final String REQUIRED_SALARY = "** Salary is required :: ";
    // CONTROLLERS MESSAGES
    public static final String DELETE_SUCCESSFULLY = "Deleted successfully...!";

    private GeneralConstants() {

    }

}
