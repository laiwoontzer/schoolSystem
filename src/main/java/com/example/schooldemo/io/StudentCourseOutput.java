package com.example.schooldemo.io;

import com.example.schooldemo.model.Course;
import com.example.schooldemo.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentCourseOutput {
    private List<Student> students;
    private Course course;

    public StudentCourseOutput(Course course) {
        this.students = new ArrayList<>();
        this.course = course;
    }

    public StudentCourseOutput(Course course, List<Student> students) {
        this.students = students;
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
}
