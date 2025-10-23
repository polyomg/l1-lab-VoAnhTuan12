package com.example.lab8.controller;

import com.example.lab8.service.MailService;
import com.example.lab8.service.MailService.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/mail")
public class MailController {

    @Autowired
    MailService mailService;

    @GetMapping("/form")
    public String form() {
        return "mail/form";
    }

    @PostMapping("/send")
    public String sendMail(@RequestParam("to") String to,
                           @RequestParam(value = "subject", required = false) String subject,
                           @RequestParam(value = "body", required = false) String body,
                           Model model) {
        mailService.push(Mail.builder().to(to).subject(subject).body(body).build());
        model.addAttribute("message", "Mail của bạn đã được xếp vào hàng đợi");
        return "mail/form";
    }

    @GetMapping("/send-now")
    @ResponseBody
    public String sendNow() {
        mailService.send("receiver@example.com", "Test Subject", "Test Body");
        return "ok";
    }
}
