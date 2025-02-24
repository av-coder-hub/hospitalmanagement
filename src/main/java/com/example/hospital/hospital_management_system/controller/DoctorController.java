package com.example.hospital.hospital_management_system.controller;

import com.example.hospital.hospital_management_system.model.Doctor;
import com.example.hospital.hospital_management_system.service.DoctorService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doctors")  // Prefix for all doctor-related requests
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Method to get all doctors
    @GetMapping
    public String getAllDoctors(Model model) {
        model.addAttribute("doctors", doctorService.findAllDoctors());
        return "doctor/list"; // Matches src/main/resources/templates/doctor/list.html
    }

    // Method to display form for adding a new doctor
    @GetMapping("/add")
    public String addDoctorForm(Model model) {
        model.addAttribute("doctor", new Doctor());  // Empty Doctor object for the form
        return "doctor/add"; // Matches src/main/resources/templates/doctor/add.html
    }

    // Method to handle the form submission for adding a new doctor
    @PostMapping("/add")
    public String addDoctor(@ModelAttribute Doctor doctor) {
        doctorService.saveOrUpdateDoctor(doctor);  // Use saveOrUpdateDoctor instead of addDoctor
        return "redirect:/doctors";  // Redirect to the list of doctors after adding
    }

    // Method to display form for editing an existing doctor
    @GetMapping("/edit/{id}")
    public String editDoctorForm(@PathVariable Long id, Model model) {
        Optional<Doctor> optionalDoctor = doctorService.getDoctorById(id);  // Get doctor by ID
        if (optionalDoctor.isPresent()) {
            model.addAttribute("doctor", optionalDoctor.get());  // Extract Doctor from Optional
            return "doctor/edit";  // Matches src/main/resources/templates/doctor/edit.html
        } else {
            return "redirect:/doctors";  // If doctor not found, redirect to doctors list
        }
    }

    // Method to handle the form submission for editing a doctor
    @PostMapping("/edit/{id}")
    public String editDoctor(@PathVariable Long id, @ModelAttribute Doctor doctor) {
        doctor.setId(id);  // Set the ID to ensure it updates the correct doctor
        doctorService.saveOrUpdateDoctor(doctor);  // Use saveOrUpdateDoctor instead of updateDoctor
        return "redirect:/doctors";  // Redirect to the list of doctors after editing
    }

    // Method to delete a doctor by ID
    @GetMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);  // Deletes doctor from the database
        return "redirect:/doctors";  // Redirect to the list of doctors after deletion
    }
}
