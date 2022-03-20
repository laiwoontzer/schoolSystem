package com.example.schooldemo.io;

public class StudentInput {
    private String studentName;
    private String gender;
    private boolean active;

    public StudentInput(String studentName, String gender, boolean status) {
        this.studentName = studentName;
        this.gender = gender;
        this.active = true;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active =  Boolean.FALSE == active ? false: true;
    }
}
