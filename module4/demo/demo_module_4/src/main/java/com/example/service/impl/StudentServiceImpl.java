package com.example.service.impl;

import com.example.model.Student;
import com.example.repository.IStudentRepository;
import com.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    private IStudentRepository iStudentRepository;

    @Autowired
    public StudentServiceImpl(IStudentRepository iStudentRepository) {
        this.iStudentRepository = iStudentRepository;
    }

    @Override
    public List<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public void create(Student student) {
        iStudentRepository.create(student);
    }

    @Override
    public void update(Student student) {
        iStudentRepository.update(student);
    }

    @Override
    public void delete(Student student) {
        iStudentRepository.delete(student);
    }

    @Override
    public Student findById(Integer id) {
        return iStudentRepository.findById(id);
    }
}
