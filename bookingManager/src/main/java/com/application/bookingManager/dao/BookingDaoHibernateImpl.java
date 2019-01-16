package com.application.bookingManager.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.bookingManager.entity.Booking;


@Repository
public class BookingDaoHibernateImpl implements BookingDao {

	private EntityManager entityManager;
	
	@Autowired	
	public BookingDaoHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public void save(Booking booking) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(booking);
		
	}

	@Override
	public List<Booking> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Booking> theQuery = currentSession.createQuery("from Booking", Booking.class);
		
		List<Booking> bookings = theQuery.getResultList();
		
		return bookings;	
	}

	@Override
	public List<Booking> findByBookedRoom(String roomName) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Booking> theQuery = currentSession.createQuery("FROM Booking inner join Room.roomName WHERE booking.bookedRoom.roomName=:roomName", Booking.class);
		
		theQuery.setParameter("roomName", roomName);
		
		List<Booking> theBookings = theQuery.getResultList();
		
		return theBookings;
	}

	@Override
	public Booking findByBookedBy(String userLogin) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("from Booking b inner join b.bookedBy user");
				
		List<Booking> theBookings = theQuery.getResultList();
		
		Booking result = null;
		for(Booking bookings: theBookings) {
			if (bookings.getBookedBy().getLogin().equals(userLogin)) {
				result = bookings;
				break;
			}
		}
		
		return result;
	}

}
