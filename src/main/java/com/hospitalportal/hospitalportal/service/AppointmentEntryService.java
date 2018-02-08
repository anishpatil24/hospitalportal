package com.hospitalportal.hospitalportal.service;

import com.hospitalportal.hospitalportal.Entity.Appointment;
import com.hospitalportal.hospitalportal.Entity.Doctor;
import com.hospitalportal.hospitalportal.Entity.Patient;
import com.hospitalportal.hospitalportal.Repository.AppointmentRepository;
import com.hospitalportal.hospitalportal.Repository.DoctorRepository;
import com.hospitalportal.hospitalportal.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AppointmentEntryService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    AppointmentRepository appointmentRepository;

    public Integer insert(Integer idPatient, Date date, Integer idDoctor) {
        try {
            Patient patient = patientRepository.findByIdPatient(idPatient);
            String patientname = patient.getPatientName();
            Doctor doctor = doctorRepository.findByIdDoctor(idDoctor);
            String doctorname = doctor.getDoctorname();
            Appointment appointment = new Appointment();
            appointment.setPatientname(patientname);
            appointment.setDoctorname(doctorname);
            appointment.setDate(date);
            appointmentRepository.save(appointment);
            return 1;
        } catch (Exception e) {
            return null;
        }
    }

}
