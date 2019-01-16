package com.application.bookingManager.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ROOMS")
public class Room {

	@Id
	@Column(name="room_name", unique=true)
	private String roomName;
	
	@Column(name="location_description")
	private String location;
	
	@Column(name="number_of_seats")
	private int numberOfSeats;
	
	@Column(name="has_projector")
	private boolean hasProjector;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@OneToMany(cascade=CascadeType.ALL,
			fetch=FetchType.LAZY,
			mappedBy="bookedRoom")
	List<Booking> bookings = new ArrayList<>();
	
	public Room() {}

	public Room(String roomName, String location, int numberOfSeats, boolean hasProjector, String phoneNumber) {
		this.roomName = roomName;
		this.location = location;
		this.numberOfSeats = numberOfSeats;
		this.hasProjector = hasProjector;
		this.phoneNumber = phoneNumber;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public boolean isHasProjector() {
		return hasProjector;
	}

	public void setHasProjector(boolean hasProjector) {
		this.hasProjector = hasProjector;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Room [roomName= " + roomName + ", location = " + location + ", numberOfSeats = " + numberOfSeats
				+ ", hasProjector = " + hasProjector + ", phoneNumber = " + phoneNumber + "]";
	};	
}
