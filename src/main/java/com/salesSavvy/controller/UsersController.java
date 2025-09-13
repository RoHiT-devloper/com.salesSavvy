package com.salesSavvy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.salesSavvy.entity.Users;
import com.salesSavvy.dto.SignInResponse;
import com.salesSavvy.entity.Product;
import com.salesSavvy.service.UsersService;
import com.salesSavvy.service.ProductService;

@CrossOrigin("*")
@RestController
public class UsersController {
    
    @Autowired
    UsersService service;

    @Autowired
    ProductService productService;
    
    @PostMapping("/data")
    public String data(@RequestBody String username) {
        System.out.println("Data Recieved: "  + username);
        return "Data Recieved: " + username;
    }
    
    @PostMapping("/signUp")
    public String signUp(@RequestBody Users user) {
        String msg = "";
        String username = user.getUsername();
        Users u = service.getUser(username);
        if(u == null) {
            service.signUp(user);
            msg = "User created successfully!";
        } else {
            msg = "User already exists!";
        }
        return msg;
    }
    
    @PostMapping("/signIn")
    public SignInResponse signIn(@RequestBody Users user) {
        String username = user.getUsername();
        String password = user.getPassword();
        
        Users u = service.getUser(username);
        if(u == null) {
            return new SignInResponse("User not found!", null);
        }

        boolean status = service.validate(username, password);
        if(status) {
            if(u.getRole().equals("admin")) {
                return new SignInResponse("admin", null);
            } else {
                // ✅ For customer, include product list
                List<Product> products = productService.getAllProducts();
                return new SignInResponse("customer", products);
            }
        } else {
            return new SignInResponse("Your Password is Wrong!", null);
        }
    }
    
    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam long id) {
        return service.deleteUser(id);
    }
    
    @GetMapping("/getAllUsers")
    public List<Users> getAllUsers() {
        return service.getAllUsers();
    }
}
