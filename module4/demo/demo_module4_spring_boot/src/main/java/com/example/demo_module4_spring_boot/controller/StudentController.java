package com.example.demo_module4_spring_boot.controller;

import com.example.demo_module4_spring_boot.dto.StudentCreateDTO;
import com.example.demo_module4_spring_boot.model.Student;
import com.example.demo_module4_spring_boot.service.IClassRoomService;
import com.example.demo_module4_spring_boot.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("StudentTalkList")
public class StudentController {

    private IStudentService iStudentService;

    private IClassRoomService iClassRoomService;

    @Autowired
    public StudentController(IStudentService iStudentService, IClassRoomService iClassRoomService) {
        this.iStudentService = iStudentService;
        this.iClassRoomService = iClassRoomService;
    }

    @ModelAttribute("studentTalkList")
    public List<Student> studentList() {
        return new ArrayList<>();
    }

    @GetMapping("/student")
    public String getList(Model model, @RequestParam(defaultValue = "0") int page) {
        if (page < 0) {
            page = 0;
        }
//        Page<Student> students = iStudentService.getAllByPage(page);
        model.addAttribute("listStudent", iStudentService.getAllByPage(page));
        return "list";
    }

    @GetMapping("/student/detail/{codeStudent}")
    public String detailByPathVariable(@PathVariable Integer codeStudent,
                                       Model model) {
        Student student = iStudentService.getStudentById(codeStudent);
        model.addAttribute("student", student);
        return "detail";
    }

    @GetMapping("/student/addRoom/{codeStudent}")
    public String addRoom(@PathVariable Integer codeStudent,
                          @ModelAttribute("studentTalkList") List<Student> studentTalkList,
                          RedirectAttributes redirect) {
        Student student = iStudentService.getStudentById(codeStudent);
        studentTalkList.add(student);
        redirect.addFlashAttribute("msg", "Add Talk list successfully");
        return "redirect:/student";
    }

    @GetMapping("/student/detail")
    public String detailByRequestParam(@RequestParam Integer id,
                                       Model model) {
        Student student = iStudentService.getStudentById(id);
        model.addAttribute("student", student);
        return "detail";
    }

    @GetMapping("/student/create")
    public String showFormCreate(Model model) {
        model.addAttribute("studentCreateDTO", new StudentCreateDTO());
        model.addAttribute("gender", new Integer[]{0, 1, 2});
        model.addAttribute("classRooms", iClassRoomService.getAll());
        return "create";
    }

//    @PostMapping("/student/create")
//    public String createStudent(@ModelAttribute("student") Student student,
//                                BindingResult bindingResult,
//                                RedirectAttributes redirect,
//                                Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("gender", new Integer[]{0, 1, 2});
//            return "create";
//        }
//        iStudentService.save(student);
//        redirect.addFlashAttribute("msg", "Thêm mới thành công");
//        return "redirect:/student";
//    }

    @PostMapping("/student/create")
    public String createStudent(@Validated @ModelAttribute("studentCreateDTO") StudentCreateDTO studentCreateDTO,
                                BindingResult bindingResult,
                                RedirectAttributes redirect,
                                HttpServletResponse response,
                                @CookieValue("countStudent") String countStudent,
                                Model model) {
//        new StudentCreateDTO().validate(studentCreateDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("gender", new Integer[]{0, 1, 2});
            model.addAttribute("classRooms", iClassRoomService.getAll());
            return "create";
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentCreateDTO, student);
        iStudentService.save(student);
        Cookie cookie = new Cookie("countStudent", Integer.parseInt(countStudent) + 1 + "");
        cookie.setMaxAge(24 * 60 * 60 * 265 * 100); // set thoi gian ton tai cua cookie, tinh theo milli giay
        response.addCookie(cookie);
        redirect.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/student";
    }

    @ExceptionHandler(Exception.class)
    public String handle() {
        return "error";
    }
}
