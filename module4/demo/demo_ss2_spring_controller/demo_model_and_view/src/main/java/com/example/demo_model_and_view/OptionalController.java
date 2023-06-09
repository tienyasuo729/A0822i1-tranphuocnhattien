package com.example.demo_model_and_view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
@Controller
public class OptionalController {
    @GetMapping(value = {"/article", "/article/{id}"})
    public String getArticle(@PathVariable(name = "id") Integer articleId) {
        if (articleId != null) {
            return "detail";
        } else {
            return "home";
        }
    }

//    @GetMapping(value = {"/article", "/article/{id}"})
//    public String getArticle(@PathVariable(name = "id") Optional<Integer> optional) {
//        if (optional.isPresent()) {
//            System.out.println(optional.get());
//            return "detail";
//        } else {
//            return "home";
//        }
//    }
}
