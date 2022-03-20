package com.example.schooldemo.exception;

import com.example.schooldemo.response.SchoolResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SchoolExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler()
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, new SchoolResponse(ex.getMessage()), new HttpHeaders(),((SchoolException) ex).getErrorCode(), request);
    }
}
