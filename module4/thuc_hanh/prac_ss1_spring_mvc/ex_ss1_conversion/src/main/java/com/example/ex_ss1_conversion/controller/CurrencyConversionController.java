package com.example.ex_ss1_conversion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;

@Controller
public class CurrencyConversionController {
    @RequestMapping(method = RequestMethod.GET, value = "conversion")
    public String showForm() {
        return "result";
    }

    @RequestMapping(method = RequestMethod.POST, value = "conversion")
    public ModelAndView currency(@RequestParam String input) {
        BigInteger result = new BigInteger(input).multiply(BigInteger.valueOf(23000));
        return new ModelAndView("result", "result", result);
    }
}
