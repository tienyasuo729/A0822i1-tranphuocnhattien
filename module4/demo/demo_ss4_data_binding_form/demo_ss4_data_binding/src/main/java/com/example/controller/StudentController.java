package com.example.controller;

import com.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudentController {
    @Autowired



    @GetMapping("/student/create")
    public String showFormCreate(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("gender", new Integer[]{0, 1, 2});
        return "create";
    }

    @PostMapping("/student/create")
    public String createStudent(@ModelAttribute("student") Student student, BindingResult bindingResult, RedirectAttributes redirect, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("gender", new Integer[]{0, 1, 2});
            return "create";
        }
        return "create";
    }
}
