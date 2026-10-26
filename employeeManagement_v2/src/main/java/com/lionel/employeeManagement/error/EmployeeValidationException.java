package com.lionel.employeeManagement.error;

public class EmployeeValidationException extends RuntimeException{
    public EmployeeValidationException(String message) {
        super(message);
    }

    public EmployeeValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeValidationException(Throwable cause) {
        super(cause);
    }
}
