package com.example.schooldemo.controller;

import com.example.schooldemo.exception.SchoolException;
import com.example.schooldemo.io.CourseInput;
import com.example.schooldemo.model.Course;
import com.example.schooldemo.model.StudentCourse;
import com.example.schooldemo.repository.CourseRepository;
import com.example.schooldemo.repository.StudentCourseRepository;
import com.example.schooldemo.response.SchoolResponse;
import com.example.schooldemo.response.SchoolStatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @PostMapping(path = "", produces = "application/json")
    public Course createCourse(@RequestBody CourseInput courseInput) {
        try {
            return courseRepository.save(new Course(courseInput));
        } catch (Exception ex) {
            throw new SchoolException(SchoolStatusCode.ExistingCourse);
        }
    }

    @GetMapping(path = "", produces = "application/json")
    public List<Course> getCourse() {
        List<Course> listCourse = courseRepository.findAll();
        return listCourse;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Course getCourse(@PathVariable String id) {
        Optional<Course> courseById = courseRepository.findById(id);
        if (courseById.isEmpty()) {
            throw new SchoolException(SchoolStatusCode.CourseNotFound);
        }
        return courseById.get();
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public Course updateCourse(@PathVariable String id, @RequestBody CourseInput courseInput) {
        Optional<Course> oldCourseData = courseRepository.findById(id);
        List<Course> listCourse = courseRepository.findAll();

        if (oldCourseData.isEmpty()) {
            throw new SchoolException(SchoolStatusCode.CourseNotFound);
        }
        Course newCourse = new Course(courseInput);
        newCourse.setCourseId(id);

        if (oldCourseData.get().equals(newCourse)) {
            throw new SchoolException(SchoolStatusCode.CourseNotModified);
        }
        for (Course course : listCourse) {
            if (course.getCourseName().equals(newCourse.getCourseName())) {
                throw new SchoolException(SchoolStatusCode.ExistingCourse);
            }
        }
        return courseRepository.save(newCourse);
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public SchoolResponse deleteCourse(@PathVariable String id) {
        Optional<Course> oldCourseData = this.courseRepository.findById(id);
        List<StudentCourse> studentCourses = this.studentCourseRepository.findStudentCourseByCourseId(id);

        if (oldCourseData.isEmpty() || studentCourses == null) {
            throw new SchoolException(SchoolStatusCode.CourseNotFound);
        }
        this.studentCourseRepository.deleteAll(studentCourses);
        this.courseRepository.delete(oldCourseData.get());
        return new SchoolResponse(SchoolStatusCode.CourseSuccessDeleted);
    }

    @PutMapping(path = "deactivate/{id}", produces = "application/json")
    public Course deactivateCourse(@PathVariable String id, @RequestBody CourseInput courseInput) {
        Optional<Course> oldCourseData = courseRepository.findById(id);
        if (oldCourseData.isEmpty()) {
            throw new SchoolException(SchoolStatusCode.CourseNotFound);
        }
        Course newCourse = oldCourseData.get();
        newCourse.setActive(courseInput.isActive());
        return courseRepository.save(newCourse);
    }
}
