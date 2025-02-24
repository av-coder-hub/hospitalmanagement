package com.example.hospital.hospital_management_system.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;         // Patient's name
    private int age;             // Patient's age
    private String gender; // Added gender field
    private String contactInfo;  // Patient's contact information (phone, email)

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;  // List of appointments for this patient

    // Constructors, Getters, and Setters
    public Patient() {}

    public Patient(String name, int age, String contactInfo) {
        this.name = name;
        this.age = age;
        this.contactInfo = contactInfo;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
