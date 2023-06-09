package com.codegym.demo_a08_spring_boot.controller;

import com.codegym.demo_a08_spring_boot.model.Student;
import com.codegym.demo_a08_spring_boot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//@RequestMapping("student")
@Controller
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    @GetMapping("/student")
    public String getList(Model model) {
//        List<Student> students = ;
        model.addAttribute("listStudent", iStudentService.getAll());
        return "list";
    }

    @GetMapping("/student/detail/{codeStudent}")
    public String detailByPathVariable(@PathVariable Integer codeStudent,
                                       Model model) {
        Student student = iStudentService.getStudentById(codeStudent);
        model.addAttribute("student", student);
        return "detail";
    }

    @GetMapping("/student/detail")
    public String detailByRequestParam(@RequestParam Integer id,
                                       Model model) {
        Student student = iStudentService.getStudentById(id);
        model.addAttribute("student", student);
        return "detail";
    }

    @GetMapping("/student/create")
    public String showFormCreate(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("gender", new Integer[]{0,1,2});
        return "create";
    }

    @PostMapping("/student/create")
    public String createStudent(@ModelAttribute("student") Student student,
                                BindingResult bindingResult,
                                RedirectAttributes redirect,
                                Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("gender", new Integer[]{0,1,2});
            return "create";
        }
        iStudentService.save(student);
        redirect.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/student";
    }



}
