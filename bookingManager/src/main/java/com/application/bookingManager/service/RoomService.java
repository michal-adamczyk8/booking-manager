package com.application.bookingManager.service;

import java.util.List;

import com.application.bookingManager.entity.Room;

public interface RoomService {

	List<Room> findAll();
	
	Room findByRoomName(String roomName);
	
	void save(Room room);
	
	void deleteByRoomName(String roomName);
}
