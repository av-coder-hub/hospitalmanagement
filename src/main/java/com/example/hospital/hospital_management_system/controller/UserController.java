package com.example.hospital.hospital_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.hospital.hospital_management_system.model.User;
import com.example.hospital.hospital_management_system.repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;  // Inject UserRepository
    
    @Autowired
    private PasswordEncoder passwordEncoder;  // Inject PasswordEncoder

    @PostMapping("/user/register")
    public String registerUser(@ModelAttribute User user) {
        // Check if user already exists
        if (userRepository.findByUsername(user.getUsername()) != null) {
            // Handle error: user already exists
            return "registrationError";  // Redirect to error page
        }

        // Encrypt the password before saving it
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        // Save user to the database
        userRepository.save(user);

        // Redirect to login page or show success message
        return "registrationSuccess";
    }
}