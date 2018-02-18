package com.example.shopping.shoppingCart.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;

    @OneToOne
    @JoinColumn(name="register_id")
    Register register;

    public Customer() {
    }

    public Customer(String name, String address, Integer mobile) {
        this.name = name;

        this.address = address;
        this.mobile = mobile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    String address;
    Integer mobile;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    Set<CustomerCart> customerCartSet;
}
