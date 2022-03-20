package com.example.schooldemo.exception;

import com.example.schooldemo.response.SchoolStatusCode;
import org.springframework.http.HttpStatus;

public class SchoolException extends RuntimeException {
    private final HttpStatus errorCode;

    public SchoolException(String message, HttpStatus errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public SchoolException(SchoolStatusCode schoolStatusCode) {
        super(schoolStatusCode.getMessage());
        this.errorCode = schoolStatusCode.getErrorCode();
    }

    public HttpStatus getErrorCode() {
        return errorCode;
    }
}
