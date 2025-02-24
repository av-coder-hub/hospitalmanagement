package com.example.hospital.hospital_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital.hospital_management_system.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Method to find user by username
    User findByUsername(String username);
    boolean existsByUsername(String username); // Check if username exists

}
