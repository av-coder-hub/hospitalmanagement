package com.example.hospital.hospital_management_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLogin(Model model) {
        // Pass error or logout messages to the login page if needed
        return "login"; // Render the login.html view
    }
}
