package com.codegym.demo_a08_spring_boot.utils.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Aspect
@Component
public class StudentAspect {

    @After("execution(* com.codegym.demo_a08_spring_boot.controller.StudentController.*(..))")
    public void logAfterMethodController(JoinPoint joinPoint) {
        String nameMethod = joinPoint.getSignature().getName();
        System.out.println(nameMethod + "date: "+ LocalDateTime.now());
        //ĐỌc ghi file
    }
}
