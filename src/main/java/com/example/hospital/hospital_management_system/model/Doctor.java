package com.example.hospital.hospital_management_system.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;             // Doctor's name
    private String specialty;        // Doctor's specialty (e.g., Cardiology, Pediatrics, etc.)
    private boolean available;       // Track doctor's availability (true = available, false = not available)

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;  // List of appointments for this doctor

    // Constructors, Getters, and Setters
    public Doctor() {}

    public Doctor(String name, String specialty, boolean available) {
        this.name = name;
        this.specialty = specialty;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
