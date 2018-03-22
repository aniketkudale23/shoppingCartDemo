package com.example.shopping.shoppingCart.daorepointerface;

import com.example.shopping.shoppingCart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.transaction.annotation.Transactional(readOnly = true)
public interface DaoProduct extends JpaRepository<Product,Integer> {
    @Override
    Product save(Product entity);
    @Transactional
    @Query("select count(*) > 0 from Product where productName = ?1")
    boolean existByProductName(String productName);
    @Transactional
    @Query("select count(*) > 0 from Product where productId = ?1")
    boolean existByProductId(Integer id);
    @Override
   // @Query("select productId, productName, price, qty, image from Product")
    List<Product> findAll();


   // List<Product> findAllByOrderByProductIdAsc();




}
