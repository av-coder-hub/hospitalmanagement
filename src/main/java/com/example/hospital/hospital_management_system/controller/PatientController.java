package com.example.hospital.hospital_management_system.controller;

import com.example.hospital.hospital_management_system.model.Patient;
import com.example.hospital.hospital_management_system.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // View all patients
    @GetMapping
    public String getAllPatients(Model model) {
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        return "patient/list"; // This points to the patient/list.html view
    }

    // Add a new patient form
    @GetMapping("/add")
    public String showAddPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient/add"; // This points to the patient/add.html view
    }

    // Save or update patient
    @PostMapping("/save")
    public String saveOrUpdatePatient(@ModelAttribute Patient patient) {
        patientService.saveOrUpdatePatient(patient);
        return "redirect:/patients"; // Redirect to list of patients after saving
    }

    // Edit patient form
    @GetMapping("/edit/{id}")
    public String showEditPatientForm(@PathVariable("id") Long id, Model model) {
        Optional<Patient> patient = patientService.getPatientById(id);
        patient.ifPresent(value -> model.addAttribute("patient", value));
        return "patient/edit"; // This points to the patient/edit.html view
    }

    // Delete a patient
    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable("id") Long id) {
        patientService.deletePatient(id);
        return "redirect:/patients"; // Redirect to list of patients after deleting
    }
}
