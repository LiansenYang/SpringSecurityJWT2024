package com.example.springsecurity20240711demo_jwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {


    @GetMapping("/logout-success")
    public String logoutSuccess() {
        return "logout-success";
    }
}
