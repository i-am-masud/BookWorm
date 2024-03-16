package com.cts.bookworm.entities;

import jakarta.persistence.Table;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
	@SequenceGenerator(name = "user_generator", sequenceName = "user_seq", allocationSize = 1, initialValue = 1)

	@Column(name = "User_Id")
	private int userId;
	@Column(name = "Full_Name")
	private String fullName;
	@Column(name = "Contact")
	private String phno;
	@Column(name = "Email")
	private String email;
	@Column(name = "Address")
	private String address;
	@Column(name = "Username")
	private String username;
	@Column(name = "Password")
	private String password;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Orders> orders;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fullName=" + fullName + ", phno=" + phno + ", email=" + email
				+ ", address=" + address + ", username=" + username + ", password=" + password + ", orders=" + orders
				+ "]";
	}
}
