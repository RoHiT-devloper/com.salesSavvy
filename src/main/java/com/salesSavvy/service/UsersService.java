package com.salesSavvy.service;

import java.util.List;

import com.salesSavvy.entity.Users;

public interface UsersService {
	void signUp(Users user);
	Users getUser(String username);
	Users getPassword(String password);
	boolean validate(String username, String password);
	List<Users> getAllUsers();
	String deleteUser(Long id);
	Users saveUser(Users user);
}
