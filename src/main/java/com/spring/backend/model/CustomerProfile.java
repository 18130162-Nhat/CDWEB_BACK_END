package com.spring.backend.model;

import com.spring.backend.entity.Customer;

public class CustomerProfile {
    private int idCus;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;

    public CustomerProfile(int idCus, String email, String firstName, String lastName, String phone) {
        this.idCus = idCus;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }
    public int getIdCus() {
        return idCus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
