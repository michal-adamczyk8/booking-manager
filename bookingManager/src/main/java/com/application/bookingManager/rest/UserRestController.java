package com.application.bookingManager.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.application.bookingManager.entity.User;
import com.application.bookingManager.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {
	
	private UserService userService;
	
	@Autowired
	public UserRestController(UserService userService) {
		this.userService=userService;
	}
	
	
	@GetMapping("/users")
	public List<User> findAllUsers() {
		return userService.findAll();
	}
	
	
	@GetMapping("/users/{userLogin}")
	public User getUser(@PathVariable String userLogin) {
		User theUser = userService.findByLogin(userLogin);
		
		if (theUser == null) {
			throw new RuntimeException("User login not found - " + userLogin);
		}
		return theUser;
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User theUser) {
		userService.save(theUser);
		
		return theUser;
	}
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User theUser) {
		
		userService.save(theUser);
		
		return theUser;
	}
	
	@DeleteMapping("/users/{userLogin}")
	public String deleteUser(@PathVariable String userLogin) {
		
		User tempUser = userService.findByLogin(userLogin);
		
		if (tempUser == null) {
			throw new RuntimeException("User login not found - " + userLogin);
		}
		
		userService.deleteByLogin(userLogin);
		
		return "User with login: " + userLogin + " has been deleted sucessfully"; 
	}

}
