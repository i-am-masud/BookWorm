package com.cts.bookworm.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cts.bookworm.entities.Books;
import com.cts.bookworm.entities.User;

public class OrdersDto {
	private int orderId;
	private LocalDate orderDate;
	private User user;
	private Double totalPrice;

	private List<Books> books = new ArrayList<>();

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
