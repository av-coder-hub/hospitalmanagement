package com.example.hospital.hospital_management_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    // Display the dashboard page
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Add any necessary data to the model
        model.addAttribute("message", "Welcome to the Dashboard!");
        return "dashboard";  // This will return the dashboard.html page
    }
}
