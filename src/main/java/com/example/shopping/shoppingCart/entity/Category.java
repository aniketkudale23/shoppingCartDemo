package com.example.shopping.shoppingCart.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer catId;
    @NotNull
    String catName;
    public Category() {

    }
    public Category(String catName) {
        this.catName = catName;
    }

    public Integer getCatId() {

        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    Set<Product> products;
}
