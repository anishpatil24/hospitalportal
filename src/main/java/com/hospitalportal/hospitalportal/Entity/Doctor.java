package com.hospitalportal.hospitalportal.Entity;

import javax.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Column(name = "id")
    private Integer id;

    @Column(name = "doctorname")
    private String doctorname;

    @Column(name = "doctorfees")
    private Integer doctorfees;

    @Column(name = "hospitalid")
    private Integer hospitalid;

    public Doctor() {
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

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public Integer getDoctorfees() {
        return doctorfees;
    }

    public void setDoctorfees(Integer doctorfees) {
        this.doctorfees = doctorfees;
    }

    public Integer getHospitalid() {
        return hospitalid;
    }

    public void setHospitalid(Integer hospitalid) {
        this.hospitalid = hospitalid;
    }
}
