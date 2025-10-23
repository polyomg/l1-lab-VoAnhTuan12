package com.example.lab8.controller;

import com.example.lab8.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {
    @GetMapping("/student/list")
    public String list(Model model) {
        List<Student> list = Arrays.asList(
                new Student("Nguyễn Văn A (Nam)", "a@gmail.com", 9.0, "CNTT"),
                new Student("Trần Thị B", "b@gmail.com", 8.0, "Marketing"),
                new Student("Lê Văn C (Nam)", "c@gmail.com", 6.0, "Kinh tế"),
                new Student("Phạm Thị D", "d@gmail.com", 4.0, "Thiết kế")
        );
        model.addAttribute("students", list);
        return "student/list";
    }
}
