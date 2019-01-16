package com.application.bookingManager.rest;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.bookinManager.exception.EntityErrorResponse;
import com.application.bookingManager.entity.Room;
import com.application.bookingManager.service.RoomService;

@RestController
@RequestMapping("/api")
public class RoomRestController {
	
	private RoomService roomService;	
	
	@Autowired
	public RoomRestController(RoomService roomService) {
		this.roomService = roomService;
	}
	
	@GetMapping("/rooms")
	public List<Room> findAllRooms() {
		return roomService.findAll();
	}
	
	@GetMapping("/rooms/{roomName}")
	public Room getRoom(@PathVariable String roomName) {
		
		Room theRoom = roomService.findByRoomName(roomName);
		
		if(theRoom == null) {
			throw new RuntimeException("Room with name not found: - " + roomName);
		}		
		return theRoom;		
	}
	
	@PostMapping("/rooms")
	public Room addRoom(@RequestBody Room room) {
				
		roomService.save(room);
		
		return room;
	}
	
	@PutMapping("/rooms")
	public Room updateRoom(@RequestBody Room room) {
		
		roomService.save(room);
		
		return room;
	}
	
	@DeleteMapping("/rooms/{roomName}")
	public String deleteRoom(@PathVariable String roomName) {
		
		Room tempRoom = roomService.findByRoomName(roomName);
		
		if (tempRoom == null) {
			throw new RuntimeException("Room name not found - " + roomName);
		}
		
		roomService.deleteByRoomName(roomName);
		
		return "Room with name: " + roomName + " has been deleted sucessfully";
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(EntityNotFoundException exc) {
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(exc.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
}
