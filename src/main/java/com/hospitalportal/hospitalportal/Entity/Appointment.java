package com.hospitalportal.hospitalportal.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "patientname")
    private String patientname;

    @Column(name = "doctorname")
    private String doctorname;

    @Column(name = "date")
    private Date date;

    public Appointment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patientname")
    private Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
