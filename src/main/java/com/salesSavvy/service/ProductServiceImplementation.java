package com.salesSavvy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesSavvy.entity.Cart;
import com.salesSavvy.entity.Product;
import com.salesSavvy.repository.CartRepository;
import com.salesSavvy.repository.ProductRepository;

@Service
public class ProductServiceImplementation implements ProductService {

	@Autowired
	ProductRepository repo;


    @Autowired
    private CartRepository cartRepo;   // ✅ inject Cart repo

	@Override
	public String addProduct(Product product) {
		repo.save(product);
		return "product added successfully";
	}

	@Override
	public Product searchProduct(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}
	
//	@Override
//	public Product searchProduct(String name) {
//		// TODO Auto-generated method stub
//		return repo.findByName(name);
//	}


	@Override
	public String updateProduct(Product product) {
		repo.save(product);
		return "product updated successfully";
	}

	@Override
	public String deleteProduct(Long id) {
		repo.deleteById(id);
		return "product deleted successfully";
	}

	@Override
	public Product searchProductByCategory(String category) {
		// TODO Auto-generated method stub
		return repo.findByCategory(category);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

    @Override
    public Product saveProduct(Product product) {
        // ✅ If product has a new cart that isn’t saved yet
        if (product.getCart() != null && product.getCart().getId() == null) {
            Cart savedCart = cartRepo.save(product.getCart()); // save cart first
            product.setCart(savedCart); // reattach managed cart
        }

        // ✅ Now safely save product
        return repo.save(product);
    }


}
