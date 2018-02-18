package com.example.shopping.shoppingCart.daorepointerface;

import com.example.shopping.shoppingCart.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DaoCategory extends JpaRepository<Category,Integer> {
    @Override
    Category save(Category entity);


    @Query("select count(*) > 0 from Category where catName = ?1")
    boolean existByCatName(String catName);
}
