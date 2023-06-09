package com.example.ss1_spring_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String showPageHello(Model model) {
        model.addAttribute("name", "Nam");
        return "a08";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hello2")
    public ModelAndView showPageHello2() {
        ModelAndView modelAndView = new ModelAndView("a08", "name", "Van Nam");
        return modelAndView;
    }
}
