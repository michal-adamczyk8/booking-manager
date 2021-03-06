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

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="USERS")
public class User {
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;

	@Id
	@Column(name="login", unique=true)
	private String login;
	
	@Column(name="password")
	@JsonIgnore
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL,
			fetch=FetchType.LAZY,
			mappedBy="bookedBy")
	List<Booking> bookings = new ArrayList<Booking>();

	public User() {}

	public User(String name, String surname, String login, String password) {
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [name = " + name + ", surname = " + surname + ", login = " + login + ", password = " + password + "]";
	}
	
	
}
