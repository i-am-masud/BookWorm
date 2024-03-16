package com.cts.bookworm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.bookworm.entities.Books;
import com.cts.bookworm.entities.User;
import com.cts.bookworm.services.BookService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
	
	@Autowired
	private BookService bookService;
	
	
	
	public List<Books> registerCart(HttpSession session) {
		@SuppressWarnings("unchecked")
		List<Books> cartBook = (List<Books>) session.getAttribute("cartBookSession");
		if (cartBook == null) {
			cartBook = new ArrayList<>();
			session.setAttribute("cartBookSession", cartBook);			
		}
		return cartBook;
	}
	
	
//	-------------------------------------------------------------------------------------------------------------------------------------------------
//	Calculating book price and returning books
//	-------------------------------------------------------------------------------------------------------------------------------------------------	
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String goToCart(Model model, HttpSession session) {
		
		User user = (User) session.getAttribute("userLoggedIn");
		
		if (user!=null) {
			List<Books> booksCart = registerCart(session);
			double totalcost = 0;
			for (Books book : booksCart) {
				totalcost += book.getPrice();
			}
					
			model.addAttribute("booksCart", booksCart);
			model.addAttribute("totalcost", totalcost);
			
			return "cart";
		}
		else {
			return "redirect:/login";
		}

		
	}
	
	
//	-------------------------------------------------------------------------------------------------------------------------------------------------
//	From book details page Adding books to the cart
//	-------------------------------------------------------------------------------------------------------------------------------------------------
	
	@GetMapping("/addtocart/{bookId}")
	public String addToCart(@PathVariable("bookId") int bookId, HttpSession session) {
		
		User user = (User) session.getAttribute("userLoggedIn");
		if (user != null) {
			List<Books> booksCart = registerCart(session);
			
			Books book = bookService.getBook(bookId);

			if (!booksCart.contains(book)) {
				booksCart.add(book);
			}
			
			return "redirect:/";
		} else {
			return "redirect:/login";
		}
		
		
	}
	
	
//	-------------------------------------------------------------------------------------------------------------------------------------------------
//	Deleting books from the cart
//	-------------------------------------------------------------------------------------------------------------------------------------------------
	
	@GetMapping("/deleteItem/{bookId}")
	public String deleteFromCart(@PathVariable("bookId") int bookId, HttpSession session) {
		
		List<Books> booksCart = registerCart(session);
		
		Books book = bookService.getBook(bookId);
		for (Books existsbook : booksCart) {
			if (existsbook.equals(book)) {
				booksCart.remove(existsbook);
				break;
			}
		}
		
		return "redirect:/cart";
	}

}

