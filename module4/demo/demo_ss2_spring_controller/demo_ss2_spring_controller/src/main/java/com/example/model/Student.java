package com.example.model;

public class Student {
    private Integer code;
    private String name;
    private Double point;
    private Integer gender;

    public Student() {
    }

    public Student(Integer code, String name, Double point, Integer gender) {
        this.code = code;
        this.name = name;
        this.point = point;
        this.gender = gender;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
