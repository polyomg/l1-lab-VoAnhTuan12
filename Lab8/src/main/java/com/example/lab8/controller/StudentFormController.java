package com.example.lab8.controller;

import com.example.lab8.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentFormController {

    @GetMapping("/student/form")
    public String form(Model model) {
        model.addAttribute("sv", new Student("", "", 0, ""));
        return "student/form";
    }

    @PostMapping("/student/save")
    public String save(@ModelAttribute("sv") Student sv, Model model) {
        model.addAttribute("message", "Lưu sinh viên thành công!");
        return "student/success";
    }
}
