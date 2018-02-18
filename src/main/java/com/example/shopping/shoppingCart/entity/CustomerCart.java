package com.example.shopping.shoppingCart.entity;

import javax.persistence.*;

@Entity
public class CustomerCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    Integer productId;
    String productName;
    Float price;
    Integer qty;
    String image;

    public CustomerCart() {

    }

    public CustomerCart(Integer productId, String productName, Float price, Integer qty, String image) {

        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.qty = qty;
        this.image = image;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne

    @JoinColumn(name = "customer_id")
    Customer customer;

}
