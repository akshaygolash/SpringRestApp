package com.akshay.service;
import java.util.List;
import com.akshay.entity.User;

public interface UserService {

	public List<User> getAll();

	public User getUserById(String userId);

	public User createUser(User user);

	public User updateUser(String userId, User user);

	public void deleteUser(String userId);



}
