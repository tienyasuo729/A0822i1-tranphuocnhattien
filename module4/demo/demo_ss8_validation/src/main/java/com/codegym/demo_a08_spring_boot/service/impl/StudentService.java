package com.codegym.demo_a08_spring_boot.service.impl;

import com.codegym.demo_a08_spring_boot.model.Student;
import com.codegym.demo_a08_spring_boot.repository.IStudentRepository;
import com.codegym.demo_a08_spring_boot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;

    @Override
    public List<Student> getAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public Page<Student> getAllByPage(int page) {

        return iStudentRepository.findAll(PageRequest.of(page,2, Sort.by("point").descending()) );
    }

    @Override
    public void save(Student student) {
        this.iStudentRepository.save(student);
    }

    @Override
    public Student getStudentById(int id) {
        return iStudentRepository.findById(id).orElse(null);
    }
}
