package com.example.schooldemo.io;

public class CourseInput {
    private String courseName;
    private boolean active;

    public CourseInput(String courseName, boolean status) {
        this.courseName = courseName;
        this.active = true;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = Boolean.FALSE == active ? false: true;
    }
}
