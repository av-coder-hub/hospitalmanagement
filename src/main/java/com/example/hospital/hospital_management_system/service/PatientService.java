package com.example.hospital.hospital_management_system.service;

import com.example.hospital.hospital_management_system.model.Patient;
import com.example.hospital.hospital_management_system.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // Save or update a patient
    public Patient saveOrUpdatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Get all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Get patient by ID
    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    // Delete a patient by ID
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
