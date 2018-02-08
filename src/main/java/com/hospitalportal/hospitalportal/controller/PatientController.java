package com.hospitalportal.hospitalportal.controller;

import com.hospitalportal.hospitalportal.Entity.Appointment;
import com.hospitalportal.hospitalportal.service.AppointmentEntryService;
import com.hospitalportal.hospitalportal.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    AppointmentService appointmentService;
    @Autowired
    AppointmentEntryService appointmentEntryService;

    @RequestMapping(value = "/rest/fetchAllAppointments", method = RequestMethod.GET)
    @ResponseBody
    public List<Appointment> handleFetchAllAppointments(@RequestBody Integer id) {

        List<Appointment> appointment = appointmentService.fetchAllAppointments(id);
        try {
            return appointment;
        } catch (NullPointerException e) {
            return null;
        }
    }

    @RequestMapping(value = "/rest/fetchAllAppointmentsOnDate", method = RequestMethod.GET)
    @ResponseBody
    public List<Appointment> handleFetchAllAppointmentsDate(@RequestParam Integer id, @RequestParam Date date) {
        List<Appointment> appointment = appointmentService.fetchAllAppointmentsDate(id, date);
        try {
            return appointment;
        } catch (NullPointerException e) {
            return null;
        }
    }

    @RequestMapping(value = "/rest/bookAppointment", method = RequestMethod.POST)
    @ResponseBody
    public String handleBookAppointment(@RequestParam Integer idPatient, @RequestParam Date date, Integer idDoctor, @RequestParam Integer hospitalid) {
        Integer isBooked = appointmentEntryService.insert(idPatient, date, idDoctor);
        if (isBooked == 1)
            return "Success";
        return null;
    }

    @RequestMapping(value = "/rest/cancelAppointment", method = RequestMethod.DELETE)
    @ResponseBody
    public String handleCancelAppointment(@RequestBody Integer id) {
        Integer isCancelled = appointmentService.delete(id);
        if (isCancelled == 1)
            return "Successfully Cancelled";
        return null;
    }

}
