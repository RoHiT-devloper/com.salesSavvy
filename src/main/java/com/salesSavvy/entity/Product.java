//package com.salesSavvy.entity;
//
//import java.util.List;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//
//import jakarta.persistence.*;
//
//@Entity
//public class Product {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private String name;
//    private String description;
//    private int price;
//    private String photo;
//    private String category;
//
//    @ElementCollection
//    private List<String> reviews;
//
//    @ManyToOne
//    @JsonBackReference
//    private Cart cart;
//
//    public Product() {}
//
//    public Product(Long id, String name, String description, int price,
//                   String photo, String category, List<String> reviews, Cart cart) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.price = price;
//        this.photo = photo;
//        this.category = category;
//        this.reviews = reviews;
//        this.cart = cart;
//    }
//
//    // Getters & Setters
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//
//    public String getDescription() { return description; }
//    public void setDescription(String description) { this.description = description; }
//
//    public int getPrice() { return price; }
//    public void setPrice(int price) { this.price = price; }
//
//    public String getPhoto() { return photo; }
//    public void setPhoto(String photo) { this.photo = photo; }
//
//    public String getCategory() { return category; }
//    public void setCategory(String category) { this.category = category; }
//
//    public List<String> getReviews() { return reviews; }
//    public void setReviews(List<String> reviews) { this.reviews = reviews; }
//
//    public Cart getCart() { return cart; }
//    public void setCart(Cart cart) { this.cart = cart; }
//
//    @Override
//    public String toString() {
//        return "Product{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", price=" + price +
//                ", category='" + category + '\'' +
//                '}'; // ❌ cart not included
//    }
//}



package com.salesSavvy.entity;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// ... other imports ...
// REMOVE this import: import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private int price;
    private String photo;
    private String category;

    @ElementCollection
    private List<String> reviews;

    // REMOVE this entire section:
    // @ManyToOne
    // @JsonBackReference
    // private Cart cart;
  public Product() {}

  public Product(Long id, String name, String description, int price, String photo, String category, List<String> reviews, Cart cart) {
      this.id = id;
      this.name = name;
      this.description = description;
      this.price = price;
      this.photo = photo;
      this.category = category;
      this.reviews = reviews;
  }

  // Getters & Setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }

  public int getPrice() { return price; }
  public void setPrice(int price) { this.price = price; }

  public String getPhoto() { return photo; }
  public void setPhoto(String photo) { this.photo = photo; }

  public String getCategory() { return category; }
  public void setCategory(String category) { this.category = category; }

  public List<String> getReviews() { return reviews; }
  public void setReviews(List<String> reviews) { this.reviews = reviews; }

@Override
public String toString() {
    return "Product{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", category='" + category + '\'' +
            '}'; 
}
   

}