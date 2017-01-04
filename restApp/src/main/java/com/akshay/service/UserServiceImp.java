package com.akshay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.akshay.entity.User;
import com.akshay.exceptions.EntityAlreadyExistException;
import com.akshay.exceptions.EntityNotFoundException;
import com.akshay.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public List<User> getAll() {
		return repository.getAll();
	}

	@Override
	public User getUserById(String userId) {
		User user = repository.getUserById(userId);
		if(user == null){
			throw new EntityNotFoundException("User not found");
		}else{
			return user;
		}	
		
	}

	@Transactional
	@Override
	public User createUser(User user) {
		User existingUser = repository.getUserByEmail(user.getEmail());
		if(existingUser != null){
			throw new EntityAlreadyExistException("User already exist");
		}else{
			return repository.crateUser(user);
		}	
		
	}

	@Transactional
	@Override
	public User updateUser(String userId, User user) {
		User existingUser = repository.getUserById(userId);
		if(existingUser == null){
			throw new EntityNotFoundException("User not found");
		}else{
		return repository.updateUser(user);
		}
	}

	@Transactional
	@Override
	public void deleteUser(String userId) {
		User existingUser = repository.getUserById(userId);
		if(existingUser == null){
			throw new EntityNotFoundException("User not found");
		}else{
			 repository.deleteUser(existingUser);
		}
	}

}
