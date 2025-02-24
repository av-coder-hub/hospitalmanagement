package com.example.hospital.hospital_management_system.service;

import com.example.hospital.hospital_management_system.model.Appointment;
import com.example.hospital.hospital_management_system.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    // Save or update an appointment
    public Appointment saveOrUpdateAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);  // Save the appointment to the database
    }

    // Get all appointments
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // Get appointments by doctor ID
    public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    // Get appointments by patient ID
    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    // Get appointments by status
    public List<Appointment> getAppointmentsByStatus(String status) {
        return appointmentRepository.findByStatus(status);
    }

    // Get appointments by date
    public List<Appointment> getAppointmentsByDate(java.util.Date appointmentDate) {
        return appointmentRepository.findByAppointmentDate(appointmentDate);
    }

    // Cancel an appointment (update status)
    public void cancelAppointment(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        appointment.ifPresent(app -> {
            app.setStatus("Canceled");
            appointmentRepository.save(app);
        });
    }

    // Delete an appointment by ID
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
