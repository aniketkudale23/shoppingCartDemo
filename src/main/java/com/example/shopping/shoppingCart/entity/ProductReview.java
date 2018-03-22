package com.example.shopping.shoppingCart.entity;

import javax.persistence.Id;

public class ProductReview extends ProductBaseEntity implements Comparable<Product>{
    @Id
    String id;
    Integer productId;
    String review;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }



    public ProductReview(Integer productId, String review) {
        this.productId = productId;
        this.review = review;
    }

    public ProductReview(String review) {
        this.review = review;

    }

    public ProductReview() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }



    @Override
    public int compareTo(Product product) {
        if (this.productName == product.productName)
        {
            return 1;
        }else
        return 0;
    }
}
