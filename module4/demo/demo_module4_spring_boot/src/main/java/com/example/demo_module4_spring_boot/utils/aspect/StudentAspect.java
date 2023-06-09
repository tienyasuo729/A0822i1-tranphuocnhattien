package com.example.demo_module4_spring_boot.utils.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class StudentAspect {
    @After("execution(* com.example.demo_module4_spring_boot.controller.StudentController.*(..))")
    public void logAfterMethodController(JoinPoint joinPoint) {
        String nameMethod = joinPoint.getSignature().getName();
        System.out.println(nameMethod + "date: " + LocalDateTime.now());
    }
}
