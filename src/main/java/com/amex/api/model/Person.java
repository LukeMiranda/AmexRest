package com.amex.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {

	@Id
	@Column(name = "person_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int personId;
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "phone", nullable = false)
	private String phone;
	@Column(name = "city", nullable = false)
	private String city;
	@Column(name = "state", nullable = false)
	private String state;

	public Person() {
		 // No args constructor
	}

	public Person(String email, String name, String phone, String city, String state) {
		super();
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.city = city;
		this.state = state;
	}

	public Person(int personId, String email, String name, String phone, String city, String state) {
		super();
		this.personId = personId;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.city = city;
		this.state = state;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", email=" + email + ", name=" + name + ", phone=" + phone + ", city="
				+ city + ", state=" + state + "]";
	}
}
