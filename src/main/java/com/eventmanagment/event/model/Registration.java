package com.eventmanagment.event.model;

import java.io.Serializable;

public class Registration implements Serializable {

    private String userid;
    private String mobphone;
    private String email;
    private String password1;
    private String password2;


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMobphone() {
        return mobphone;
    }

    public void setMobphone(String mobphone) {
        this.mobphone = mobphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
