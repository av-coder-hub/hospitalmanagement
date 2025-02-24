package com.example.hospital.hospital_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.hospital.hospital_management_system.model.User;
import com.example.hospital.hospital_management_system.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Check if user exists by username
    public boolean userExists(String username) {
        // Directly fetch the user, return false if not found
        User user = userRepository.findByUsername(username);
        return user != null;  // Return true if user exists, otherwise false
    }

    // Validate user credentials manually
    public boolean validateUserCredentials(String username, String password) {
        // Fetch the user directly
        User user = userRepository.findByUsername(username);
        
        // If user not found, return false
        if (user == null) {
            return false;
        }

        // Validate password
        return passwordEncoder.matches(password, user.getPassword());
    }

    // Register a new user
    public void registerUser(User user) {
        // Encrypt password before saving it
        user.setPassword(passwordEncoder.encode(user.getPassword()));  // Encode the password
        userRepository.save(user);  // Save the user to the repository
    }
}
