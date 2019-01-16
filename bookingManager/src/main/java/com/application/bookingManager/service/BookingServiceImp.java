package com.application.bookingManager.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.bookingManager.dao.BookingDao;
import com.application.bookingManager.entity.Booking;

@Service
public class BookingServiceImp implements BookingService {

	private BookingDao bookingDao;
	
	@Autowired
	public BookingServiceImp(BookingDao bookingDao) {
		this.bookingDao = bookingDao;
	}
	
	@Override
	@Transactional
	public void save(Booking booking) {
		bookingDao.save(booking);
	}

	@Override
	@Transactional
	public List<Booking> findAll() {
		return bookingDao.findAll();
	}

	@Override
	@Transactional
	public List<Booking> findOneByBookedRoom(String roomName) {
		return bookingDao.findByBookedRoom(roomName);
	}

	@Override
	@Transactional
	public Booking findOneByBookedBy(String userLogin) {
		return bookingDao.findByBookedBy(userLogin);
	}

}
