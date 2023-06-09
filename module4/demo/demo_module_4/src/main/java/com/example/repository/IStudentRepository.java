package com.example.repository;

import com.example.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    void create(Student student);

    void update(Student student);

    void delete(Student student);

    Student findById(Integer id);
}
