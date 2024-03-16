package com.cts.bookworm.controller;

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
public class DetailsController {

	private BookService bookService;

	@Autowired
	public DetailsController(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(value = "/details/{bookId}", method = RequestMethod.GET)
	public String goToIndex(@PathVariable("bookId") int bookId, Model model) {

		Books book = bookService.getBook(bookId);

		model.addAttribute("book", book);

		return "details";
	}


}
