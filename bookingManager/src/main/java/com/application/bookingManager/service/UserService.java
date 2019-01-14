package com.application.bookingManager.service;

import java.util.List;

import com.application.bookingManager.entity.User;

public interface UserService {
	
	List<User> findAll();
	
	User findByLogin(String login);
	
	void save(User user);
	
	void deleteByLogin(String login);

}
