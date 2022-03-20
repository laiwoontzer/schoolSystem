package com.example.schooldemo.model;

import com.example.schooldemo.io.CourseInput;
import com.example.schooldemo.io.StudentInput;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "course_id", unique = true, nullable = false, length = 40)
    private String courseId;

    @Column(name = "course_name", length = 200, unique = true)
    private String courseName;

    @Column(name = "active")
    private boolean active;

    @Column(name = "created_timestamp")
    private LocalDateTime createdTimestamp;

    public Course() {

    }

    // lazy reloading re-assignment
    public Course(Course course) {
        this.courseId = course.getCourseId();
        this.courseName = course.getCourseName();
        this.active = course.isActive();
        this.createdTimestamp = course.getCreatedTimestamp();
    }

    public Course (CourseInput courseInput){
        this.courseName = courseInput.getCourseName();
        this.active = courseInput.isActive();
        this.createdTimestamp  = LocalDateTime.now();
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Course) {
            Course course = (Course) obj;
            return this.courseName.equals(course.courseName) &&
                    this.active == course.active;
        }
        return false;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
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
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", active='" + active + '\'' +
                ", createdTimestamp=" + createdTimestamp +
                '}';
    }
}
