package com.example.hospital.hospital_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital.hospital_management_system.model.Patient;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // Custom query method to find patients by name
    List<Patient> findByName(String name);

    // Custom query method to find patients by age
    List<Patient> findByAge(int age);
}
