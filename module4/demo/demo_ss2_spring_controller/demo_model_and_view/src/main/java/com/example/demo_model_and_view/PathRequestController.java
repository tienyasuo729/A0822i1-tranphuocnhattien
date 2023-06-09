package com.example.demo_model_and_view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PathRequestController {
    @RequestMapping(value = "requestParam")
    public void testRequestParam(@RequestParam String user, @RequestParam int age) {
        System.out.println("User: " + user);
        System.out.println("Age: " + age);
    }

    @RequestMapping(value = "pathVariable/{id}/{name}")
    public void testPathVariable(@PathVariable int id, @PathVariable String name) {
        System.out.println("ID " + id);
        System.out.println("Name " + name);
    }
}
