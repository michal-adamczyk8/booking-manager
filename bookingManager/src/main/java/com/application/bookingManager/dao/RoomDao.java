package com.application.bookingManager.dao;

import java.util.List;

import com.application.bookingManager.entity.Room;

public interface RoomDao {

	List<Room> findAll();
	
	Room findByRoomName(String roomName);
	
	void save(Room room);
	
	void deleteByRoomName(String roomName);
}
