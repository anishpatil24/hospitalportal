package com.hospitalportal.hospitalportal.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hospital")
public class Hospital {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "hospitalname")
    private String hospitalname;
    @Column(name = "registrationstatus")
    private Integer registrationstatus;

    public Hospital() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(String hospitalname) {
        this.hospitalname = hospitalname;
    }

    public Integer getRegistrationstatus() {
        return registrationstatus;
    }

    public void setRegistrationstatus(Integer registrationstatus) {
        this.registrationstatus = registrationstatus;
    }

}
