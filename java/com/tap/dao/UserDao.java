package com.tap.dao;

import java.util.List;

import com.tap.model.User;

public interface UserDao {

	void addUser(User user);

	User getUser(int userId);

	List<User> getAll();

	void updateUser(User user);

	void deleteUser(int userId);
	
	boolean authenticate(String userName, String password);
	
}
