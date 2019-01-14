package com.application.bookingManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.bookingManager.dao.UserDao;
import com.application.bookingManager.entity.User;


@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao=userDao;
	}
	
	@Override
	@Transactional
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	@Transactional
	public User findByLogin(String login) {
		return userDao.findByLogin(login);
	}

	@Override
	@Transactional
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	@Transactional
	public void deleteByLogin(String login) {
		userDao.deleteByLogin(login);
	}
}
