package com.salesSavvy.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    @JsonBackReference
    private Users user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Product> productList;

    public Cart() {}

    public Cart(Long id, Users user, List<Product> productList) {
        this.id = id;
        this.user = user;
        this.productList = productList;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Users getUser() { return user; }
    public void setUser(Users user) { this.user = user; }

    public List<Product> getProductList() { return productList; }
    public void setProductList(List<Product> productList) { this.productList = productList; }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", productCount=" + (productList != null ? productList.size() : 0) +
                '}'; // ❌ user not included
    }
}
