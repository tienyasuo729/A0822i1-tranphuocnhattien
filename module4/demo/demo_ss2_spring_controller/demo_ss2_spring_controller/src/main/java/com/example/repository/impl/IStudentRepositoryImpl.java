package com.example.repository.impl;

import com.example.model.Student;
import com.example.repository.IStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class IStudentRepositoryImpl implements IStudentRepository {
    public static List<Student> list;
    static {
        list = new ArrayList<>();
        list.add()
    }
    @Override
    public Student getAll() {
        return null;
    }
}
