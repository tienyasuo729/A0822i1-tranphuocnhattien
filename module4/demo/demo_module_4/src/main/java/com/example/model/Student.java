package com.example.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Student {
    private Integer codeStudent;
    private String nameStudent;
    private Double point;
    private Integer gender;

    public Student() {
    }

    public Student(Integer code, String name, Double point, Integer gender) {
        this.codeStudent = code;
        this.nameStudent = name;
        this.point = point;
        this.gender = gender;
    }

    public Integer getCode() {
        return codeStudent;
    }

    public void setCode(Integer code) {
        this.codeStudent = code;
    }

    public String getName() {
        return nameStudent;
    }

    public void setName(String name) {
        this.nameStudent = name;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
