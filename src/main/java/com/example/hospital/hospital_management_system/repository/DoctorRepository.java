package com.example.hospital.hospital_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital.hospital_management_system.model.Doctor;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    
    // Custom query method to find doctors by availability status
    List<Doctor> findByAvailable(boolean available);

    // Custom query method to find doctors by specialty
    List<Doctor> findBySpecialty(String specialty);
}
