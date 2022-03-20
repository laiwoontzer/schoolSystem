package com.example.schooldemo.repository;

import com.example.schooldemo.model.Student;
import com.example.schooldemo.model.StudentCourse;
import com.example.schooldemo.model.StudentCourseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, StudentCourseId> {

    List<StudentCourse> findStudentCourseByCourseId(String courseId);

    List<StudentCourse> findStudentCourseByStudentId(String studentId);

    @Query(value = "select s from StudentCourse sc left join Student s on sc.studentId = s.studentId where sc.courseId=?1")
    List<Student> findStudentByCourseId(String courseId);


}
