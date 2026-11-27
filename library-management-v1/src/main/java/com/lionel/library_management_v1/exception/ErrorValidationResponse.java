package com.lionel.library_management_v1.exception;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public class ErrorValidationResponse extends ErrorResponse{
    private Map<String, List<String>> errors  ;

    public ErrorValidationResponse(int status, String message, Instant timeStamp, Map<String, List<String>> errors) {
        super(status, message, timeStamp);
        this.errors = errors;
    }

    public Map<String, List<String>> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, List<String>> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ErrorValidationResponse{" +
                "errors=" + errors +
                '}';
    }
}
