package com.codegym.demo_a08_spring_boot.service;

import com.codegym.demo_a08_spring_boot.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IStudentService {
    Page<Student> getAllByPage(int page);

    List<Student> getAll();

    void save(Student student);

    Student getStudentById(int id);
}
