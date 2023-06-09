package com.example.controller;

import com.example.model.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/calculator")
    public String showForm(Model model) {
        model.addAttribute("number", new Calculator());
        return "/calculator";
    }

    @PostMapping("calculator")
    public String calculate(@ModelAttribute("number") Calculator calculator, Model model) {
        switch (calculator.getButton()) {
            case "add" -> {
                model.addAttribute("result", calculator.getNumberFirst() + calculator.getNumberSecond());
            }
            case "sub" -> {
                model.addAttribute("result", calculator.getNumberFirst() - calculator.getNumberSecond());
            }
            case "mul" -> {
                model.addAttribute("result", calculator.getNumberFirst() * calculator.getNumberSecond());
            }
            case "div" -> {
                model.addAttribute("result", calculator.getNumberFirst() / calculator.getNumberSecond());
            }
            default -> {
                model.addAttribute("result", 0);
            }
        }
        return "/calculator";
    }

}
