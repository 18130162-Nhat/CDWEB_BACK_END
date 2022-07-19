package com.spring.backend.entity;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCustomer ;
    @Column(name = "pass_word")
    private String pass ;
    @Column(name = "phone")
    private String phone ;
    @Column(name = "email")
    private String email ;
    @Column(name = "role")
    private String role ;
    @Column(name = "status")
    private String status ;
    @Column(name = "first_name")
    private String firstName ;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "gender")
    private String gender ;
    @Column(name = "timestamp")
    private Timestamp time ;
    @Column(name = "code")
    private String code ;
    @Column(name = "avatar")
    private  String linkAvatar ;

    @OneToMany(mappedBy = "customer")
    private List<Order> orderList ;

    public Customer( String pass, String phone, String email, String role, String status, String firstName, String lastName, String gender, Timestamp time, String code, String linkAvatar, List<Order> orderList) {
        this.pass = pass;
        this.phone = phone;
        this.email = email;
        this.role = role;
        this.status = status;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.time = time;
        this.code = code;
        this.linkAvatar = linkAvatar;
        this.orderList = orderList;
    }

    public Customer() {
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLinkAvatar() {
        return linkAvatar;
    }

    public void setLinkAvatar(String linkAvatar) {
        this.linkAvatar = linkAvatar;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
