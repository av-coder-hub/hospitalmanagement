package com.example.hospital.hospital_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.hospital.hospital_management_system.model.User;
import com.example.hospital.hospital_management_system.repository.UserRepository;
import org.springframework.ui.Model;  // Correct import for Spring MVC Model



@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;  // UserService to handle user registration logic
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
    	
    	System.out.println("trying to register" + user.toString());
        // Hash the user's password
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        
        // Set the encoded password to the user object
        user.setPassword(encodedPassword);

        // Save the user to the database
        userRepository.save(user);

        // Redirect to the login page after successful registration
        return "redirect:/login";
    }
    
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register"; // Show the registration form
    }
}