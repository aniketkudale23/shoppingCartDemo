package com.example.shopping.shoppingCart.controller;

import com.example.shopping.shoppingCart.daorepointerface.DaoCategory;
import com.example.shopping.shoppingCart.daorepointerface.DaoLogin;
import com.example.shopping.shoppingCart.daorepointerface.DaoProduct;
import com.example.shopping.shoppingCart.daorepointerface.DaoRegister;
import com.example.shopping.shoppingCart.entity.Category;
import com.example.shopping.shoppingCart.entity.Login;
import com.example.shopping.shoppingCart.entity.Product;
import com.example.shopping.shoppingCart.entity.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@ResponseBody
@CrossOrigin
@RequestMapping("/user")
@ComponentScan
public class RegistrationController {
    @Autowired
    DaoRegister daoRegister;
    @Autowired
    DaoLogin daoLogin;
    @Autowired
    DaoCategory daoCategory;
    @Autowired
    DaoProduct daoProduct;
    @Autowired
    HttpSession session;


    @PostMapping("/register")
    public boolean makeRegister(@RequestBody Register register)
    {
        System.out.println("inside register" + register.getRegisterId() + register.getEmail());
        boolean val = daoRegister.existByEmail(register.getEmail().trim());

        //find by email here only
        if (val) {
            return false;
        } else {

            Register r = new Register(register.getEmail(), register.getPassword(), register.getRole());
            System.out.println(r.toString() + "Value");
            daoRegister.save(r);
            Login l = new Login(register.getEmail(), register.getPassword());
            daoLogin.save(l);
        }
        return true;
    }

    @PostMapping("/login")
    public boolean Login(@RequestParam String email, @RequestParam String password) {
        boolean exist = daoLogin.existByEmail(email, password);
        System.out.println(exist + "IS EXIST");
        if (exist) {
          Register entity =   daoRegister.findByEmail(email);
          String role = entity.getRole();
          System.out.println(entity.toString()+ "loginIN");
            session.setAttribute("user", email);
            session.setAttribute("role", role);
            System.out.println("IN LOGIN EMAIL IS "+email+ session.getAttribute("role"));

        }
        //return String.valueOf(session.getAttribute("role"));
        return exist;
    }
    @GetMapping("/check")
    public String check() {
        System.out.println("IN CHECK");
        return "Checking";
    }
    @PostMapping("/addProduct")
    public String addProduct(@RequestBody Product product) {
        System.out.println( "EXIST" + product.toString());
        boolean exist = daoProduct.existByProductName(product.getProductName());
        System.out.println("EXIST" + exist);
        if (exist) {
            return "false";
        } else {
            Product product1 = new Product(product.getProductName(), product.getPrice(), product.getQty(), product.getImage());
           product1.setCategory(product.getCategory());
            daoProduct.save(product1);
        }
        return "sucessful";
    }

    @PostMapping("/addCategory")
    public String addCategory(@RequestBody Category category) {
        boolean exist = daoCategory.existByCatName(category.getCatName());
        System.out.println("count is " + exist);
        if (exist) {
            return "false";
        } else {
            Category cat = new Category(category.getCatName());
            Category category1 = daoCategory.save(cat);
        }
        return "sucessful";
    }

    @GetMapping("/showProduct")
    public ResponseEntity<List<Product>> showProduct()
    { System.out.println("IN HERE");
        String[] str  = session.getValueNames();
        for(String s: str)
        {
            System.out.println("IN SESSION getvaluename" + s);
        }
   String email = (String)session.getAttribute("user");
   String role   = (String)session.getAttribute("role");
        System.out.println("Email is "+email+"ROLE IS "+role);

        List<Product> products = daoProduct.findAll(sortByIdAsc());

        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    private Sort sortByIdAsc()
    {
        return new Sort(Sort.Direction.ASC, "productId");

    }
}


