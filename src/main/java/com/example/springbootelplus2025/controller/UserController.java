package com.example.springbootelplus2025.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    @PostMapping("/user/test")
    public String UserTest(@RequestBody Map<String, String> map) {
        return "SUCCESS";
    }
}
