package com.example.schooldemo.response;

public class SchoolResponse {
    private String message;

    public SchoolResponse(String message) {
        this.message = message;
    }

    //pass in schoolStatusCode
    public SchoolResponse(SchoolStatusCode schoolStatusCode) {
        this.message = schoolStatusCode.getMessage();
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
