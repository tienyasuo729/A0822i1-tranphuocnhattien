package com.codegym.demo_a08_spring_boot.service;

import com.codegym.demo_a08_spring_boot.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();

    void save(Student student);

    Student getStudentById(int id);
}
