package com.application.bookingManager.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.bookingManager.entity.User;

@Repository
public class UserDAOHibernateImpl implements UserDao {

	private EntityManager entityManager;
	
	@Autowired
	public UserDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<User> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<User> theQuery = currentSession.createQuery("from User", User.class);
		
		List<User> users = theQuery.getResultList();
		
		return users;		
	}

	@Override
	public User findByLogin(String login) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		User theUser = currentSession.get(User.class, login);
		
		return theUser;
	}

	@Override
	public void save(User theUser) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theUser);
	}

	@Override
	public void deleteByLogin(String login) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from User where login=:userLogin");
		
		theQuery.setParameter("userLogin", login);
		
		theQuery.executeUpdate();
	}

}