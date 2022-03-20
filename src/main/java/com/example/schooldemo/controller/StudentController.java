package com.example.schooldemo.controller;

import com.example.schooldemo.exception.SchoolException;
import com.example.schooldemo.io.StudentInput;
import com.example.schooldemo.model.Student;
import com.example.schooldemo.model.StudentCourse;
import com.example.schooldemo.repository.StudentCourseRepository;
import com.example.schooldemo.repository.StudentRepository;
import com.example.schooldemo.response.SchoolResponse;
import com.example.schooldemo.response.SchoolStatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @GetMapping(path = "", produces = "application/json")
    public List<Student> getStudents() {
        List<Student> listStudent = studentRepository.findAll();
        return listStudent;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Student getStudent(@PathVariable String id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new SchoolException(SchoolStatusCode.StudentNotFound);
        }
        return student.get();
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public Student updateStudent(@PathVariable String id, @RequestBody StudentInput student) {
        Optional<Student> oldStudentData = studentRepository.findById(id);
        if (oldStudentData.isEmpty()) {
            throw new SchoolException(SchoolStatusCode.StudentNotFound);
        }

        Student newStudent = new Student(student);
        newStudent.setStudentId(id);
        if (oldStudentData.get().equals(newStudent)) {
            throw new SchoolException(SchoolStatusCode.StudentNotModified);
        }

        return studentRepository.save(newStudent);
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public SchoolResponse deleteStudent(@PathVariable String id) {
        Optional<Student> student = studentRepository.findById(id);
        List<StudentCourse> studentCourses = studentCourseRepository.findStudentCourseByStudentId(id);

        if (student.isEmpty() || studentCourses == null) {
            throw new SchoolException(SchoolStatusCode.StudentNotFound);
        }

        studentCourseRepository.deleteAll(studentCourses);
        studentRepository.delete(student.get());

        return new SchoolResponse(SchoolStatusCode.StudentSuccessDeleted);
    }

    @PostMapping(path = "", produces = "application/json")
    public Student createStudent(@RequestBody StudentInput student) {
        return studentRepository.save(new Student(student));
    }

    @PutMapping(path = "deactivate/{id}", produces = "application/json")
    public Student deactivateStudent(@PathVariable String id, @RequestBody StudentInput studentInput) {
        Optional<Student> oldStudentData = studentRepository.findById(id);
        if (oldStudentData.isEmpty()) {
            throw new SchoolException(SchoolStatusCode.CourseNotFound);
        }
        Student newStudent = oldStudentData.get();
        newStudent.setActive(studentInput.isActive());
        return studentRepository.save(newStudent);
    }
}
