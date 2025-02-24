package com.example.hospital.hospital_management_system.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "appointment_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")  // Specify the format for the date
    private Date appointmentDate;  // Date and time of the appointment

    private String status;  // Status (e.g., booked, canceled)

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;  // The doctor associated with the appointment

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;  // The patient who booked the appointment

    // Constructors, Getters, and Setters
    public Appointment() {}

    public Appointment(Date appointmentDate, String status, Doctor doctor, Patient patient) {
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.doctor = doctor;
        this.patient = patient;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
