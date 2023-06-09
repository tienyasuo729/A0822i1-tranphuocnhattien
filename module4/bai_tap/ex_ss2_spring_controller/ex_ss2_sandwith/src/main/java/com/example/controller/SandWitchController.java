package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandWitchController {
    @GetMapping(value = "/SandWitch")
    public String showForm() {
        return "input";
    }

    @PostMapping(value = "/SandWitch")
    public String update(@RequestParam("choose") String[] condiment, Model model){
        model.addAttribute("result", condiment);
        return "result";
    }
}
