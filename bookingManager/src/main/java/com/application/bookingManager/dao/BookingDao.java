package com.application.bookingManager.dao;

import java.util.List;

import com.application.bookingManager.entity.Booking;
import com.application.bookingManager.entity.Room;
import com.application.bookingManager.entity.User;

public interface BookingDao {
	void save(Booking booking);
	
	List<Booking> findAll();
	
	List<Booking> findByBookedRoom(String roomName);
	
	Booking findByBookedBy(String userLogin);
	

}
