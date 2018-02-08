package com.hospitalportal.hospitalportal.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {

    @Column(name = "id")
    private Integer id;
    @Column(name = "patientname")
    private String patientName;
    @Column(name = "registrationstatus")
    private Integer registrationStatus;

    public Patient() {
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(Integer registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointment;

    public List<Appointment> getAppointment() {
        return appointment;
    }

    public void setAppointment(List<Appointment> appointment) {
        this.appointment = appointment;
    }
}
