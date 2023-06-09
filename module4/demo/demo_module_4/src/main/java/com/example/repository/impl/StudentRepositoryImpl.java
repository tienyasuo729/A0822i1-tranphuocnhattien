package com.example.repository.impl;

import com.example.model.Student;
import com.example.repository.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Repository
public class StudentRepositoryImpl implements IStudentRepository {
    private static List<Student> studentList;

    static {
        studentList = new ArrayList<>();
        studentList.add(new Student(1, "Huy", 5.0, 0));
        studentList.add(new Student(1, "Hanh", 6.0, 1));
        studentList.add(new Student(1, "Nam", 7.0, 0));
        studentList.add(new Student(1, "Thu", 8.0, 1));
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void create(Student student) {
        studentList.add(student);
    }

    @Override
    public void update(Student student) {
        studentList.set(student.getCode(), student);
    }

    @Override
    public void delete(Student student) {
        studentList.remove(student);
    }

    @Override
    public Student findById(Integer id) {
        for (Student student : studentList) {
            if (Objects.equals(student.getCode(), id)) {
                return student;
            }
        }
        return null;
    }
}
