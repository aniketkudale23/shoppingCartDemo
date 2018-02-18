package com.example.shopping.shoppingCart.entity;

import javax.persistence.*;

@Entity
@Table(name="login")
public class Login {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    String email;
    String password;

    public Login() {

    }

    public Login(Integer id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Login(String email, String password) {

        this.email = email;
        this.password = password;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
