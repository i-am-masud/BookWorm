package com.cts.bookworm.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.bookworm.entities.Books;
import com.cts.bookworm.entities.Orders;
import com.cts.bookworm.entities.User;
import com.cts.bookworm.repos.OrdersRepository;


@Service
public class OrderService {
	@Autowired
	private OrdersRepository ordersRepository;

	public Orders placeOrder(User user, List<Books> books) {
		Orders orders = new Orders();

		double totalPrice = 0;
		for (Books book : books) {
			totalPrice += book.getPrice();
		}

		orders.setTotalPrice(totalPrice);
		orders.setBooks(books);
		orders.setUser(user);
		orders.setOrderDate(LocalDate.now());
		
		Orders orderSaved = ordersRepository.save(orders);
		return orderSaved;
	}
	
	public List<Orders> getAllOrders(int userId) {
		
		List<Orders> ordersList = ordersRepository.findUserOrderById(userId);
		return ordersList;
		
	}
}
