package com.application.bookingManager.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="BOOKING")
public class Booking {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="booked_from", nullable=false)
	private Date bookedFrom;
	
	@Column(name="booked_to", nullable=false)
	private Date bookedTo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_login", nullable=false)
	private User bookedBy;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="room_roomName", nullable=false)
	private Room bookedRoom;

	public Booking() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getBookedFrom() {
		return bookedFrom;
	}

	public void setBookedFrom(Date bookedFrom) {
		this.bookedFrom = bookedFrom;
	}
	
	public Date getBookedTo() {
		return bookedTo;
	}

	public void setBookedTo(Date bookedTo) {
		this.bookedTo = bookedTo;
	}

	public User getBookedBy() {
		return bookedBy;
	}

	public void setBookedBy(User bookedBy) {
		this.bookedBy = bookedBy;
	}

	public Room getBookedRoom() {
		return bookedRoom;
	}

	public void setBookedRoom(Room bookedRoom) {
		this.bookedRoom = bookedRoom;
	}
}
