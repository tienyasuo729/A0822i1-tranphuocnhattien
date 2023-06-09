package com.example.demo_module4_spring_boot.service.impl;

import com.example.demo_module4_spring_boot.model.Student;
import com.example.demo_module4_spring_boot.repository.IStudentRepository;
import com.example.demo_module4_spring_boot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    private IStudentRepository iStudentRepository;

    @Autowired
    public StudentService(IStudentRepository iStudentRepository) {
        this.iStudentRepository = iStudentRepository;
    }

    @Override
    public List<Student> getAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public Page<Student> getAllByPage(int page) {
        return iStudentRepository.findAll(PageRequest.of(page, 5));
//        return iStudentRepository.findAll(PageRequest.of(page, 5, Sort.by("point").descending()));
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
