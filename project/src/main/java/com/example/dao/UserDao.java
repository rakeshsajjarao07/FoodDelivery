package com.example.dao;

import java.util.List;

import com.example.model.User;

public interface UserDao {

	 void addUser(User user);
	    User getUserById(int userId);
	    List<User> getAllUsers();
	    void updateUser(User user);
	    void deleteUser(int userId);
	    User getUserDetails(String username);
}
