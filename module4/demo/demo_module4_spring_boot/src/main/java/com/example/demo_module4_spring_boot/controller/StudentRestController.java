package com.example.demo_module4_spring_boot.controller;

import com.example.demo_module4_spring_boot.dto.StudentCreateDTO;
import com.example.demo_module4_spring_boot.model.Student;
import com.example.demo_module4_spring_boot.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {
    private final IStudentService iStudentService;

    public StudentRestController(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }

    @GetMapping("")
    public ResponseEntity<List<Student>> getList() {
        List<Student> students = iStudentService.getAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> createStudent(@Valid @RequestBody StudentCreateDTO studentCreateDTO) {
        Student student = new Student();
        BeanUtils.copyProperties(studentCreateDTO, student);
        iStudentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
