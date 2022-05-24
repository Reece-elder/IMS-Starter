package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Customer {

	private Long id;
	private String firstName;
	private String surname;
	private String username;
	private String password;
	
	public Customer(String firstName, String surname, String username, String password) {
		this.setFirstName(firstName);
		this.setSurname(surname);
		this.setUsername(username);
		this.setPassword(password);
	}

	public Customer(Long id, String firstName, String surname, String username, String password) {
		this.setId(id);
		this.setFirstName(firstName);
		this.setSurname(surname);
		this.setUsername(username);
		this.setUsername(password);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", surname=" + surname + ", username=" + username
				+ ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, password, surname, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password) && Objects.equals(surname, other.surname)
				&& Objects.equals(username, other.username);
	}
	
	

	

}
