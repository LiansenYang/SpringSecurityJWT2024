package com.example.springsecurity20240711demo_jwt.controller;

import com.example.springsecurity20240711demo_jwt.model.User;
import com.example.springsecurity20240711demo_jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        user.setEnabled(true);
        if (userService.usernameExists(user.getUsername())) {
            model.addAttribute("error", "Username already exists.");
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/login";
    }
}
