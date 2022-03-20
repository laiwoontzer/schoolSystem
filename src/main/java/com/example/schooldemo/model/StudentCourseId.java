package com.example.schooldemo.model;

import java.io.Serializable;

public class StudentCourseId implements Serializable {
    private String courseId;
    private String studentId;

    public StudentCourseId() {
    }

    public StudentCourseId(String courseId, String studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }


}
