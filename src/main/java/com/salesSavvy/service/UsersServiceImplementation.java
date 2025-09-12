package com.salesSavvy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesSavvy.entity.Users;
import com.salesSavvy.repository.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersService{
	@Autowired
	UsersRepository repo;

	@Override
	public void signUp(Users user) {
		repo.save(user);
		
	}

	public Users getUser(String username) {
		return repo.findByUsername(username);
	}

	@Override
	public Users getPassword(String password) {
		// TODO Auto-generated method stub
		return repo.findByPassword(password);
	}

	@Override
	public boolean validate(String username, String password) {
		Users user = getUser(username);
		String dbPassword = user.getPassword();
		return (password.equals(dbPassword));
	}

    public Users saveUser(Users user) {
    	System.out.println(user + "Product Added");
        return repo.save(user);  // ✅ this will persist user + cart (because of cascade)
    }
	
	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public String deleteUser(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return "User deleted Successfully!";
	} 
}
