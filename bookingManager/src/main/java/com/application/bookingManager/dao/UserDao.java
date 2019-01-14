package com.application.bookingManager.dao;

import java.util.List;

import com.application.bookingManager.entity.User;

public interface UserDao {
	
	List<User> findAll();
	
	User findByLogin(String login);
	
	void save(User theUser);
	
	void deleteByLogin(String login);
}
