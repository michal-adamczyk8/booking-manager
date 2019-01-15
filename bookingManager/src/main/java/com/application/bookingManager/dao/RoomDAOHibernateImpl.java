package com.application.bookingManager.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.bookingManager.entity.Room;

@Repository
public class RoomDAOHibernateImpl implements RoomDao {

	private EntityManager entityManager;
	
	@Autowired
	public RoomDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	@Override
	public List<Room> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Room> theQuery = currentSession.createQuery("from Room", Room.class);
		
		List<Room> rooms = theQuery.getResultList();
		
		return rooms;		
	}

	@Override
	public Room findByRoomName(String roomName) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Room theRoom = currentSession.get(Room.class, roomName);
		
		return theRoom;
	}

	@Override
	public void save(Room theRoom) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theRoom);
	}

	@Override
	public void deleteByRoomName(String roomName) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from Room where room_name=:roomName");
		
		theQuery.setParameter("roomName", roomName);
		
		theQuery.executeUpdate();
	}
}
