package com.hospitalportal.hospitalportal.controller;

import com.hospitalportal.hospitalportal.Entity.Appointment;
import com.hospitalportal.hospitalportal.service.AppointmentEntryService;
import com.hospitalportal.hospitalportal.service.AppointmentServiceForHospital;
import com.hospitalportal.hospitalportal.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class HospitalController {

    @Autowired
    AppointmentServiceForHospital appointmentServiceForHospital;
    @Autowired
    AppointmentEntryService appointmentEntryService;
    @Autowired
    DoctorService doctorService;

    @RequestMapping(value = "/rest/fetchAllAppointmentsForHospital", method = RequestMethod.GET)
    public List<Appointment> handleFetchAllAppointments(@RequestBody Integer id) {
        List<Appointment> appointment = appointmentServiceForHospital.fetchAllAppointments(id);
        try {
            return appointment;
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "/rest/fetchAllAppointmentsForHospitalDate", method = RequestMethod.GET)
    public List<Appointment> handleFetchAllAppointmentsDate(@RequestParam Integer id, @RequestParam Date date) {
        List<Appointment> appointment = appointmentServiceForHospital.fetchAllAppointmentsDate(id, date);
        try {
            return appointment;
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "/rest/fetchAllAppointmentsForDoctor", method = RequestMethod.GET)
    public List<Appointment> handleFetchAllAppointmentsForDoctor(@RequestParam Integer id, @RequestParam String doctorname) {
        List<Appointment> appointment = appointmentServiceForHospital.fetchAllAppointmentsForDoctor(id, doctorname);
        try {
            return appointment;
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "/rest/createDoctor", method = RequestMethod.POST)
    public String handleCreateDoctor(@RequestParam String doctorname, @RequestParam Integer doctorfees, @RequestParam Integer hospitalid) {
        Integer created = doctorService.create(doctorname, doctorfees, hospitalid);
        if (created == 1)
            return "Successfully created";
        return null;
    }

    @RequestMapping(value = "/rest/modifyDoctor", method = RequestMethod.PUT)
    public String handleModifyDoctor(@RequestBody Integer doctorfees) {
        Integer modified = doctorService.modify(doctorfees);
        if (modified == 1)
            return "Successfully modified";
        return null;
    }

    @RequestMapping(value = "/rest/deleteDoctor", method = RequestMethod.DELETE)
    public String handleDeleteDoctor(@RequestBody Integer id) {
        Integer deleted = doctorService.delete(id);
        if (deleted == 1)
            return "Successfully deleted";
        return null;
    }

    @RequestMapping(value = "/rest/cancelAppointment", method = RequestMethod.DELETE)
    public String handleCancelAppointment(@RequestBody Integer id) {
        Integer isCancelled = appointmentServiceForHospital.cancel(id);
        if (isCancelled == 1)
            return "Successfully cancelled";
        return null;
    }

    @RequestMapping(value = "/rest/totalEarningsForDate", method = RequestMethod.GET)
    public Integer handleTotalEarningsForDate(@RequestBody Date date)
    {
        Integer totalEarning = appointmentServiceForHospital.fetchTotalEarningsForDate(date);
    }
}