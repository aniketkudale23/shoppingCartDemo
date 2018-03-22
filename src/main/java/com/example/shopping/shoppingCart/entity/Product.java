package com.example.shopping.shoppingCart.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer productId;
   public String productName;
    Float price;
    Integer qty;
    String image;

    public Product(String productName, Float price, Integer qty, String image) {
        this.productName = productName;
        this.price = price;
        this.qty = qty;
        this.image = image;

    }

    public Product() {

    }

    public Product(Integer productId, String productName, Float price, Integer qty, String image, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.qty = qty;
        this.image = image;
        this.category = category;
    }

//    @Override
//    public String toString() {
//        return "Product{" +
//                "productId=" + productId +
//                ", productName='" + productName + '\'' +
//                ", price=" + price +
//                ", qty=" + qty +
//                ", image='" + image + '\'' +
//                ", category=" + category +
//                '}';
//    }

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


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="category_id")
    Category category;

}
