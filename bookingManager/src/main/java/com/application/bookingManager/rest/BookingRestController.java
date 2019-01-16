package com.application.bookingManager.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.bookinManager.exception.EntityErrorResponse;
import com.application.bookingManager.entity.Booking;
import com.application.bookingManager.service.BookingService;

@RestController
@RequestMapping("/api")
public class BookingRestController {

	private BookingService bookingService;
	
	@Autowired
	public BookingRestController(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	@GetMapping("/bookings")
	public List<Booking> findAllBookings() {
		return bookingService.findAll();
	}
	
	@GetMapping("/bookings/room/{roomName}")
	public List<Booking> getBookingByRoomName(@PathVariable String roomName) {
		
		List<Booking> theBookings = bookingService.findOneByBookedRoom(roomName);
		
		if(theBookings == null) {
			throw new RuntimeException("Booking for room with name not found: - " + roomName);
		}		
		return theBookings;		
	}
	
	@GetMapping("/bookings/user/{userLogin}")
	public List<Booking> getRoomByUserLogin(@PathVariable String userLogin) {
		
		List<Booking> theBookings = bookingService.findOneByBookedRoom(userLogin);
		
		if(theBookings == null) {
			throw new RuntimeException("Booking made by user login not found - " + userLogin);
		}		
		return theBookings;		
	}
	
	@PostMapping("/bookings")
	public Booking addBooking(@RequestBody Booking booking) {
		
		bookingService.save(booking);
		
		return booking;
	}
	
	@PutMapping("/bookings")
	public Booking updateBooking(@RequestBody Booking booking) {
		
		bookingService.save(booking);
		
		return booking;
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
