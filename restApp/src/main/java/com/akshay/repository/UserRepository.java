package com.akshay.repository;

import java.util.List;

import com.akshay.entity.User;

public interface UserRepository {
	
	public List<User> getAll();
	public User getUserById(String userId);
	public User getUserByEmail(String email);
	public User crateUser(User user);
	public User updateUser(User user);
	public void deleteUser(User existingUser);

}
