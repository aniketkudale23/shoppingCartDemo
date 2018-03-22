package com.example.shopping.shoppingCart.daorepointerface;

import com.example.shopping.shoppingCart.entity.ProductReview;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductReviewRepo extends MongoRepository<ProductReview, String>{
    @Override
    List<ProductReview> findAll(Sort sort);
    ProductReview findByProductName(String productName);
}
