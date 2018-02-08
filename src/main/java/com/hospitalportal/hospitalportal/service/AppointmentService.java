package com.hospitalportal.hospitalportal.service;

import com.hospitalportal.hospitalportal.Entity.Appointment;
import com.hospitalportal.hospitalportal.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;

    public List<Appointment> fetchAllAppointments(Integer id) {
        List<Appointment> appointment = appointmentRepository.findAllAppointments(id);
        try {
            return appointment;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Appointment> fetchAllAppointmentsDate(Integer id, Date date) {
        List<Appointment> appointment = appointmentRepository.findAllAppointmentsDate(id, date);
        try {
            return appointment;
        } catch (Exception e) {
            return null;
        }
    }


    public Integer delete(Integer id) {
        try {
            appointmentRepository.deleteById(id);
        } catch (Exception e) {
            return null;
        }
        return 1;
    }
}

