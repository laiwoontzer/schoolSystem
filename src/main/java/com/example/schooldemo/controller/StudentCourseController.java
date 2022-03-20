package com.example.schooldemo.controller;

import com.example.schooldemo.exception.SchoolException;
import com.example.schooldemo.io.StudentCourseOutput;
import com.example.schooldemo.model.Course;
import com.example.schooldemo.model.Student;
import com.example.schooldemo.model.StudentCourse;
import com.example.schooldemo.repository.CourseRepository;
import com.example.schooldemo.repository.StudentCourseRepository;
import com.example.schooldemo.repository.StudentRepository;
import com.example.schooldemo.response.SchoolStatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/studentCourse")
public class StudentCourseController {

    @Autowired
    private StudentCourseRepository studentCourseRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;

    @CrossOrigin(origins = "*")
    @GetMapping(path = "", produces = "application/json")
    public List<StudentCourseOutput> getAllStudentEnrolledInCourse () {
        List<Course> courses = this.courseRepository.findAll();
        List<StudentCourseOutput> studentCourseOutputs = new ArrayList<>();
        for(Course course: courses) {
            StudentCourseOutput output = new StudentCourseOutput(course);
            List<Student> students = this.studentCourseRepository.findStudentByCourseId(course.getCourseId());
            output.setStudents(students);
            studentCourseOutputs.add(output);
        }
        return studentCourseOutputs;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/{courseId}", produces = "application/json")
    public List<Student> getStudentEnrolledInCourse (@PathVariable String courseId) {
        return this.studentCourseRepository.findStudentByCourseId(courseId);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/enroll/{courseId}", produces = "application/json")
    public StudentCourseOutput enrollCourse(@PathVariable String courseId, @RequestBody List<String> studentIds) {
        final Course courseToEnroll = this.courseRepository.getById(courseId);
        if (courseToEnroll == null) {
            throw new SchoolException(SchoolStatusCode.CourseNotFound);
        }

        final StudentCourseOutput studentCourseOutput = new StudentCourseOutput(new Course(courseToEnroll));
        final List<StudentCourse> allStudentCourse = this.studentCourseRepository.findStudentCourseByCourseId(courseId);
        for (String studentId: studentIds) {
            // Empty student throw exception
            final Student student = this.studentRepository.getById(studentId);
            if (student == null) {
                throw new SchoolException(SchoolStatusCode.StudentNotFound);
            }

            /// Already enroll
            for(StudentCourse studentCourse : allStudentCourse){
                if(student.getStudentId().equals(studentCourse.getStudentId())){
                    throw new SchoolException(SchoolStatusCode.RegisteredCourse);
                }
            }
            studentCourseOutput.addStudent(new Student(student));
        }
        this.studentCourseRepository
                .saveAll(studentCourseOutput
                        .getStudents()
                        .stream()
                        .map((output) -> new StudentCourse(output.getStudentId(),  courseId)).collect(Collectors.toList()));
        return studentCourseOutput;
    }
}
