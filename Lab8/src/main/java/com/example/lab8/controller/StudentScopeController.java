package com.example.lab8.controller;

import com.example.lab8.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("students")
public class StudentScopeController {

    // Khởi tạo danh sách sinh viên trong session nếu chưa có
    @ModelAttribute("students")
    public List<Student> getStudents() {
        return new ArrayList<>();
    }

    // Hiển thị form nhập
    @GetMapping("/student/scope/form")
    public String form(Model model) {
        model.addAttribute("sv", new Student("", "", 0, ""));
        return "student/form";
    }

    // Lưu sinh viên vào session
    @PostMapping("/student/scope/save")
    public String save(@ModelAttribute("sv") Student sv,
                       @ModelAttribute("students") List<Student> list,
                       Model model) {
        list.add(sv);
        model.addAttribute("message", "Đã thêm sinh viên vào session!");
        return "student/success";
    }

    // Hiển thị danh sách sinh viên trong session
    @GetMapping("/student/scope/list")
    public String list(@ModelAttribute("students") List<Student> list, Model model) {
        model.addAttribute("students", list);
        return "student/list";
    }
}
