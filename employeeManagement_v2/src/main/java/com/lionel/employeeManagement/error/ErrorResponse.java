package com.lionel.employeeManagement.error;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


public class ErrorResponse {
    private LocalDateTime time;
    private HttpStatus status;
    private String message;

    public ErrorResponse(String message, HttpStatus status) {
        this.time = LocalDateTime.now();
        this.message = message;
        this.status = status;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
