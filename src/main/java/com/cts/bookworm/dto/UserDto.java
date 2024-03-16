package com.cts.bookworm.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDto {

	private int userId;

	@NotEmpty(message = "Can't be empty!")
//	@Pattern(regexp = "[A-Z][a-z]", message="Alphabets only"))
	private String fullName;

//	@NotEmpty(message = "Can't be empty!")
	@Pattern(regexp = "^[0-9]{10}$", message = "Can only be 10 digits")
	private String phno;

	@NotEmpty(message = "Can't be empty!")
	@Email(message = "Enter in e-mail format")
	private String email;
	@NotEmpty(message = "Can't be empty!")
	private String address;
	@NotEmpty(message = "Can't be empty!")
	private String username;

	@Size(min = 8, max = 15, message = "Min 8 to max 15 characters")
//	@NotEmpty(message = "Can't be empty!")
	private String password;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

}
