package com.hospitalportal.hospitalportal.service;

import com.hospitalportal.hospitalportal.Entity.Appointment;
import com.hospitalportal.hospitalportal.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppointmentServiceForHospital {

    @Autowired
    AppointmentRepository appointmentRepository;

    public List<Appointment> fetchAllAppointments(Integer id) {

        List<Appointment> appointment = appointmentRepository.findAllAppointmentsForHospital(id);
        try {
            return appointment;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Appointment> fetchAllAppointmentsDate(Integer id, Date date) {
        List<Appointment> appointment = appointmentRepository.findAllAppointmentsForHospitalDate(id, date);
        try {
            return appointment;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Appointment> fetchAllAppointmentsForDoctor(Integer id, String doctorname) {
        List<Appointment> appointment = appointmentRepository.findAllAppointmentsForDoctor(id, doctorname);
        try {
            return appointment;
        } catch (Exception e) {
            return null;
        }
    }

    public Integer cancel(Integer id) {
        try {
            appointmentRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            return null;
        }
    }

    public Integer fetchTotalEarningsForDate(Date date) {
        Integer totalEarnings = appointmentRepository.findTotalEarningsForDate(date);
    }
}
