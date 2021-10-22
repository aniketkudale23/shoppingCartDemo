package com.example.shopping.shoppingCart.daorepointerface;

import com.example.shopping.shoppingCart.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface DaoLogin extends JpaRepository<Login,Integer> {
    @Override
     Login save(Login login);


    boolean exists(Integer integer);
    @Transactional
    @Query("select count(email) > 0 from Login where email = ?1  AND password = ?2")
    boolean existByEmail(String email, String password);
}
