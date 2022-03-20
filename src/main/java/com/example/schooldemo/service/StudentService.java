package com.example.schooldemo.service;

import com.example.schooldemo.model.Student;
import com.example.schooldemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> listAll(){
        return (List<Student>) studentRepository.findAll();
    }
}
