package com.example.schooldemo.response;

import org.springframework.http.HttpStatus;

public enum SchoolStatusCode {
    //Student
    StudentNotFound("Student Not found",  HttpStatus.NOT_FOUND),
    StudentNotModified("Student Not Modified",  HttpStatus.NOT_MODIFIED),
    StudentSuccessDeleted("Student Successful Deleted",  HttpStatus.OK),
    //Course
    CourseNotFound("Course Not found",  HttpStatus.NOT_FOUND),
    CourseNotModified("Course Not Modified",  HttpStatus.NOT_MODIFIED),
    CourseSuccessDeleted("Course Successful Deleted",  HttpStatus.OK),
    ExistingCourse("Existing Course",  HttpStatus.CONFLICT),
    RegisteredCourse("Student Has been Registered The Course",  HttpStatus.CONFLICT);

    private HttpStatus errorCode;
    private String message;

    SchoolStatusCode(String message, HttpStatus errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public HttpStatus getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}
