package com.example.hospital.hospital_management_system.service;

import com.example.hospital.hospital_management_system.model.Doctor;
import com.example.hospital.hospital_management_system.repository.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // Save or update a doctor
    public Doctor saveOrUpdateDoctor(Doctor doctor) {
        return doctorRepository.save(doctor); // This will save or update the doctor
    }

    // Get all doctors
    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    // Get doctor by ID
    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    // Get doctors by availability status
    public List<Doctor> getDoctorsByAvailability(boolean available) {
        return doctorRepository.findByAvailable(available);
    }

    // Delete a doctor by ID
    public boolean deleteDoctor(Long id) {
        if (doctorRepository.existsById(id)) {
            doctorRepository.deleteById(id);
            return true; // Indicate success
        }
        return false; // Indicate failure
    }
}
