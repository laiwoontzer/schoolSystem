package com.example.schooldemo.repository;

import com.example.schooldemo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String>{

    
}
