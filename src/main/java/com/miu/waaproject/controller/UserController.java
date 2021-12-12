package com.miu.waaproject.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @GetMapping("/login")
    public String LoginPage() {
        return "Welcome to login";
    }

}
