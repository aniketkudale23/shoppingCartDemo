package com.example.shopping.shoppingCart.entity;

import javax.persistence.*;

@Table(name="register")
@Entity
public class Register {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer registerId;
    String email;
    String password;
    String role;
    @OneToOne(mappedBy = "register", cascade = CascadeType.REMOVE)
    private Customer customer;

    public Register() {

    }

    public Register(String email, String password, String role) {

        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return this.email + this.role + this.password;
    }

    public Integer getRegisterId() {

        return registerId;
    }

    public void setRegisterId(Integer registerId) {
        this.registerId = registerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
