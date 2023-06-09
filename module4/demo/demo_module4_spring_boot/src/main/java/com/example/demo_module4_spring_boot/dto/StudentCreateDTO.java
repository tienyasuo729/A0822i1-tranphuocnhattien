package com.example.demo_module4_spring_boot.dto;

import com.example.demo_module4_spring_boot.model.ClassRoom;
import com.example.demo_module4_spring_boot.utils.annotation.NameFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentCreateDTO implements Validator {
    @NotBlank(message = "Ten khong duoc de trong")
    @NameFormat(message = "Ten khong duoc chua ki tu")
    private String nameStudent;
    @NotNull(message = "Diem khong duoc de trong")
    @Min(value = 0, message = "Diem khong duoc nho hon 0")
    @Max(value = 10, message = "Diem khong duoc lon hon 10")
    private Double point;
    private Integer gender;
    private ClassRoom classRoom;

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
        if (!createDTO.nameStudent.matches("^[A-Za-z ]{4,50}$")) {
            errors.rejectValue("nameStudent", "", "Ten dinh dang khong dung");
        }
    }
}
