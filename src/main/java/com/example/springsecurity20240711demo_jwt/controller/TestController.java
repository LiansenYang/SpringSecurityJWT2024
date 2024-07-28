package com.example.springsecurity20240711demo_jwt.controller;

import com.example.springsecurity20240711demo_jwt.model.dto.UserTest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/new")
    public String heah(){
        return "get it";
    }

    @PostMapping("/new2")
    public String heah2(@RequestBody UserTest userTest){
        System.out.println(userTest.getUsername());
        System.out.println(userTest.getPassword());
        return "get it2";
    }
}
