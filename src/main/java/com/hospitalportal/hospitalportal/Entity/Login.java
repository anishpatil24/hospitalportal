package com.hospitalportal.hospitalportal.Entity;


import javax.persistence.*;

@Entity
@Table(name = "login")
public class Login {

    @Column(name = "password")
    private String password;

    @Column(name = "usertype")
    private String usertype;

    @Column(name = "username")
    private String username;

    @Column(name = "id")
    private long id;

    public Login() {
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
