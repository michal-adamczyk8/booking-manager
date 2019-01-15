package com.application.bookingManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.bookingManager.dao.RoomDao;
import com.application.bookingManager.entity.Room;

@Service
public class RoomServiceImpl implements RoomService {

	private RoomDao roomDao;
	
	@Autowired
	public RoomServiceImpl(RoomDao roomDao) {
		this.roomDao = roomDao;
	}	
	
	@Override
	@Transactional
	public List<Room> findAll() {
		return roomDao.findAll();
	}

	@Override
	@Transactional
	public Room findByRoomName(String roomName) {
		return roomDao.findByRoomName(roomName);
	}

	@Override
	@Transactional
	public void save(Room room) {
		roomDao.save(room);
	}

	@Override
	@Transactional
	public void deleteByRoomName(String roomName) {
		roomDao.deleteByRoomName(roomName);
	}
}
