package com.akshay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.entity.User;
import com.akshay.service.UserService;


@RestController
@RequestMapping(value="users",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
	
	@Autowired
	private UserService service;
	
	//To get all users
	@RequestMapping(method=RequestMethod.GET)
	public List<User> getAll(){
		return service.getAll();
	}
	
	//To get single user by ID
	@RequestMapping( method = RequestMethod.GET,value="{id}")
	public User getUserById(@PathVariable("id") String userId){
		return service.getUserById(userId);
	}
	
	//To Create a user
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User createUser(@RequestBody User user){
		return service.createUser(user);
	}

	//To update the user
	@RequestMapping(method=RequestMethod.PUT,value="{id}",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User updateUser(@PathVariable("id") String userId,@RequestBody User user){
		return service.updateUser(userId, user);
	}
	
	//To delete the user
	@RequestMapping(method=RequestMethod.DELETE,value="{id}")
	public void updateDelete(@PathVariable("id") String userId){
		 service.deleteUser(userId);
	}
}
