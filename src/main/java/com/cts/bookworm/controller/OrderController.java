package com.cts.bookworm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cts.bookworm.entities.Books;
import com.cts.bookworm.entities.Orders;
import com.cts.bookworm.entities.User;
import com.cts.bookworm.services.OrderService;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	

	@GetMapping("/orderedsuccessfully")
	public String showOrders(HttpSession session) {

		User user = (User) session.getAttribute("userLoggedIn");
		@SuppressWarnings("unchecked")
		List<Books> books = (List<Books>) session.getAttribute("cartBookSession");

		if (user != null) {
			Orders placeOrder = orderService.placeOrder(user, books);
			if (placeOrder != null) {
				session.removeAttribute("cartBookSession");
				return "orderplacedsuccessfully";
			}
		}
		return "redirect:/home";
	}
	
	
	@GetMapping("/orders")
	public String getOrderPage(HttpSession session, Model model) {
		
		User user = (User) session.getAttribute("userLoggedIn");
		
		if (user != null) {
			List<Orders> ordersList = orderService.getAllOrders(user.getUserId());
			
			model.addAttribute("ordersList", ordersList);
			
			return "orders";
		}
		
		else {
			
			return "redirect:/login";
		}
		
	}
	
	
}
