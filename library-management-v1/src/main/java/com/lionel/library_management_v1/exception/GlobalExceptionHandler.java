package com.lionel.library_management_v1.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> globalException(Exception exception){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Internel server error", Instant.now());
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorValidationResponse> handleValidations(ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> errors = exception.getConstraintViolations();
        Map<String, List<String>> errorList = new HashMap<>();
        for (ConstraintViolation error : errors) {
            String field = error.getPropertyPath().toString();
            String errorMsg = error.getMessage();
            if(errorList.containsKey(field)){
                String prevMsg = "";
                ListIterator<String> prevErrors = errorList.get(field).listIterator();
                while (prevErrors.hasNext()){
                    prevMsg = prevMsg.isEmpty()?"":",";
                    prevMsg = prevMsg + prevErrors.next();
                }
                errorList.put(field,List.of(prevMsg,errorMsg));
            }else{
                errorList.put(field,List.of(errorMsg));
            }
        }
        System.out.println("lakshmanan : "+errorList);
        ErrorValidationResponse errorValidationResponse = new ErrorValidationResponse(HttpStatus.BAD_REQUEST.value(),"Validation Failed", Instant.now(),errorList);
        return new ResponseEntity<>(errorValidationResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> httpMessageNotReadableException(Exception exception){
        System.out.println("lakshmanan : "+exception.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Invalid datatype found",Instant.now());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
