package com.example.schooldemo.model;

import com.example.schooldemo.io.StudentInput;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "student_id", unique = true, nullable = false, length = 40)
    private String studentId;

    @Column(name = "student_name", length = 200)
    private String studentName;

    @Column(name = "gender", length = 6)
    private String gender;

    @Column(name = "active")
    private boolean active;

    @Column(name = "created_timestamp")
    private LocalDateTime createdTimestamp;

    public Student() {

    }

    // lazy reloading re-assignment
    public Student(Student student) {
        this.studentId = student.getStudentId();
        this.studentName = student.getStudentName();
        this.gender = student.getGender();
        this.active = student.isActive();
        this.createdTimestamp = LocalDateTime.now();
    }

    public Student(StudentInput studentInput) {
        this.studentName = studentInput.getStudentName();
        this.gender = studentInput.getGender();
        this.active = studentInput.isActive();
        this.createdTimestamp = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student student = (Student) obj;
            return this.studentName.equals(student.studentName) &&
                    this.gender.equals(student.gender) &&
                    this.active == student.active;
        }
        return false;
    }


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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
        this.active = active;
    }

    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender='" + gender + '\'' +
                ", active='" + active + '\'' +
                ", createdTimestamp=" + createdTimestamp +
                '}';
    }
}
