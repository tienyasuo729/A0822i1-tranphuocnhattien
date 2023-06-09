package com.example.controller;

import com.example.model.Student;
import com.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudentController {

    private IStudentService iStudentService;

    @Autowired
    public StudentController(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }

    @GetMapping("/student")
    public String getList(Model model) {
        model.addAttribute("listStudent", iStudentService.findAll());
        return "list";
    }

    @GetMapping("/student/detail/{codeStudent}")
    public String detailByPathVariable(@PathVariable Integer codeStudent,
                                       Model model) {
        Student student = iStudentService.findById(codeStudent);
        model.addAttribute("student", student);
        return "detail";
    }

    @GetMapping("/student/create")
    public String showFormCreate(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("gender", new Integer[]{0, 1, 2});
        return "create";
    }

    @PostMapping("/student/create")
    public String createStudent(@RequestParam("codeStudent") Integer code,
                                @RequestParam("nameStudent") String name,
                                @RequestParam("point") Double point,
                                @RequestParam("gender") Integer gender,
                                RedirectAttributes redirect) {
        Student student = new Student(code, name, point, gender);
        iStudentService.create(student);
        redirect.addFlashAttribute("msg", "them moi thanh cong");
        return "redirect:/student";
    }
}
