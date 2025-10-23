package com.example.lab8.controller;

import com.example.lab8.entity.Account;
import com.example.lab8.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AccountService accountService;

    @Autowired
    HttpSession session;

    @GetMapping("/login")
    public String loginForm(Model model) {
        return "auth/login";
    }

    @PostMapping("/login")
    public String loginProcess(Model model,
                               @RequestParam("username") String username,
                               @RequestParam("password") String password) {
        Account user = accountService.findById(username);
        if (user == null) {
            model.addAttribute("message", "Invalid username!");
            return "auth/login";
        } else if (!user.getPassword().equals(password)) {
            model.addAttribute("message", "Invalid password!");
            return "auth/login";
        } else {
            session.setAttribute("user", user);
            model.addAttribute("message", "Login successfully!");
            String securityUri = (String) session.getAttribute("securityUri");
            if (securityUri != null) {
                return "redirect:" + securityUri;
            }
            return "auth/login";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        session.removeAttribute("user");
        return "redirect:/auth/login";
    }
}
