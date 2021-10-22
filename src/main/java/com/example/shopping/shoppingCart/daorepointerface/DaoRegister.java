package com.example.shopping.shoppingCart.daorepointerface;

import com.example.shopping.shoppingCart.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface DaoRegister extends JpaRepository<Register,Integer> {
    @Override
    Register save(Register register);

//   @Query(nativeQuery = true, value = "select count(register_id) > 0  from register where register_id =  ?")
//   boolean checkForId(Integer id);


    boolean exists(Integer register_id);
//    @Query("select count(email) > 0 from Register where email = ?")
//    boolean findByEmail(String email);



    @Transactional
    @Query("select count(*) > 0 from Register where email = ?1")
    boolean existByEmail(String email);
    @Transactional
    Register findByEmail(String email);
}
