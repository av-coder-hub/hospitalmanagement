package com.example.hospital.hospital_management_system.controller;

import com.example.hospital.hospital_management_system.model.Appointment;
import com.example.hospital.hospital_management_system.model.Doctor;
import com.example.hospital.hospital_management_system.model.Patient;
import com.example.hospital.hospital_management_system.service.AppointmentService;
import com.example.hospital.hospital_management_system.service.DoctorService;
import com.example.hospital.hospital_management_system.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final DoctorService doctorService;
    private final PatientService patientService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, DoctorService doctorService, PatientService patientService) {
        this.appointmentService = appointmentService;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    @GetMapping("/add")
    public String showAddAppointmentForm(Model model) {
        List<Doctor> doctors = doctorService.findAllDoctors();
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("doctors", doctors);
        model.addAttribute("patients", patients);
        return "appointment/add"; // This points to the appointment/add.html view
    }

    @GetMapping
    public String getAllAppointments(Model model) {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        model.addAttribute("appointments", appointments);
        return "appointment/list"; // This points to the appointment/list.html view
    }

    // Save or update appointment
    @PostMapping("/save")
    public String saveOrUpdateAppointment(@ModelAttribute Appointment appointment) {
        appointmentService.saveOrUpdateAppointment(appointment);
        return "redirect:/appointments"; // Redirect to list of appointments after saving
    }

    @GetMapping("/cancel/{id}")
    public String cancelAppointment(@PathVariable("id") Long id) {
        appointmentService.cancelAppointment(id);
        return "redirect:/appointments"; // Redirect to list of appointments after canceling
    }

    @GetMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable("id") Long id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/appointments"; // Redirect to list of appointments after deleting
    }
}
