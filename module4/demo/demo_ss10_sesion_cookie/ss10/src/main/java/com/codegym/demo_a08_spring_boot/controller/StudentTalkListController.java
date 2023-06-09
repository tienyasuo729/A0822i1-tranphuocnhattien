package com.codegym.demo_a08_spring_boot.controller;

import com.codegym.demo_a08_spring_boot.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class StudentTalkListController {

    @GetMapping("talk")
    public String getTalk(@SessionAttribute("studentTalkList") List<Student> studentList,
                          Model model)  {
        model.addAttribute("studentList", studentList);
        return "talkList";
    }
}
