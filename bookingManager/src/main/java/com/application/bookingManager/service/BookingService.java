package com.application.bookingManager.service;

import java.util.List;

import com.application.bookingManager.entity.Booking;


public interface BookingService {
	
	void save(Booking booking);
	
	List<Booking> findAll();
	
	List<Booking> findOneByBookedRoom(String roomName);
	
	Booking findOneByBookedBy(String userName);
}
