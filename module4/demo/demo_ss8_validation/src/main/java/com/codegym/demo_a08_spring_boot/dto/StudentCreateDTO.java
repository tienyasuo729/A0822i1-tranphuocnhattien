package com.codegym.demo_a08_spring_boot.dto;

import com.codegym.demo_a08_spring_boot.model.ClassRoom;
import com.codegym.demo_a08_spring_boot.utils.annotation.NameFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class StudentCreateDTO implements Validator {

    @NotBlank(message = "Tên không để trống")
    @NameFormat(message = "Abc")
    private String nameStudent;
    @NotNull(message = "Điểm không được để trống")
    @Min(value = 0, message = "Điểm không được nhỏ hơn 0")
    private Double point;

    private Integer gender;
    private ClassRoom classRoom;

    public StudentCreateDTO() {
    }

    public StudentCreateDTO(String nameStudent, Double point, Integer gender, ClassRoom classRoom) {
        this.nameStudent = nameStudent;
        this.point = point;
        this.gender = gender;
        this.classRoom = classRoom;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
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

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
          StudentCreateDTO createDTO = (StudentCreateDTO) target;
          if(!createDTO.nameStudent.matches("^[A-Za-z ]{4,50}$")) {
               errors.rejectValue("nameStudent", "", "Tên không đúng định dạng");
          }
    }
}
