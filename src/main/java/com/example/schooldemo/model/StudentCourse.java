package com.example.schooldemo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "studentCourse")
@IdClass(StudentCourseId.class)
public class StudentCourse implements Serializable {

    // because composite id,compound id, primary key //@IdClass(StudentCourseId.class)
    @Id
    private String studentId;
    @Id
    private String courseId;

    public StudentCourse() {

    }

    public StudentCourse(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }


    public String getStudentId() {
        return this.studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
