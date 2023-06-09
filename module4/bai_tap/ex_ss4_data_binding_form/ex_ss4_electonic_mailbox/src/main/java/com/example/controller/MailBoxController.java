package com.example.controller;

import com.example.model.Mail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MailBoxController {

    @GetMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("mail", new Mail());
        model.addAttribute("language", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("size", new Integer[]{5, 10, 15, 25, 50, 100});
        return "input";
    }

    @PostMapping("/showForm")
    public String updateDate(@ModelAttribute("mail") Mail mail, RedirectAttributes redirect) {
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String showFormSuccess() {
        return "success";
    }
}
