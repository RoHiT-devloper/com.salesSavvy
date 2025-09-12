package com.salesSavvy.service;

import java.util.List;

import com.salesSavvy.entity.Product;

public interface ProductService {
	String addProduct(Product product);
	Product searchProduct(Long id);

//	Product searchProduct(String name); 
	Product searchProductByCategory(String category);
	String updateProduct(Product product);
	String deleteProduct(Long id);
	
	Product saveProduct(Product product);

	List<Product> getAllProducts();
}
