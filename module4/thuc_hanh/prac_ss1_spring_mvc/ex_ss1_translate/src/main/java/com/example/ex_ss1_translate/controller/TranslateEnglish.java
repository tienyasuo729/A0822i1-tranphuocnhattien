package com.example.ex_ss1_translate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TranslateEnglish {
    public static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("hello", "xin chào");
        map.put("difference", "khác nhau");
        map.put("conversion", "chuyển đổi");
        map.put("currency", "tiền tệ");
    }

    @RequestMapping(method = RequestMethod.GET, value = "view")
    public String showFormView() {
        return "view";
    }

    @RequestMapping(method = RequestMethod.POST, value = "view")
    public ModelAndView translate(@RequestParam("input") String input) {
        String result = map.get(input);
        if (result == null) {
            return new ModelAndView("view", "result", "Khong tim thay");
        }
        return new ModelAndView("view", "result", result);
    }
}
