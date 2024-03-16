package com.cts.bookworm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.bookworm.entities.Books;
import com.cts.bookworm.exception.BookNotFoundException;
import com.cts.bookworm.services.BookService;

@Controller
public class IndexController {

	private BookService bookService;

	@Autowired
	public IndexController(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String goToIndex(Model model) {

		List<Books> bestSellingBooks = bookService.getGenreBooks("BestSelling");

		model.addAttribute("bestSellingBooks", bestSellingBooks);

		return "index";
	 }

//	----------------------------------------------------------------------------------------------------------------------------------
//	Searching for books
//	----------------------------------------------------------------------------------------------------------------------------------

	@GetMapping(value = "/searchbooks")
	public String searchBooks(@RequestParam("searchbooks") String bookName, ModelMap model){
		
		List<Books> books = bookService.findBookByBookName(bookName);
		
		if(books == null) {
			throw new BookNotFoundException();
		} else {
			model.addAttribute("searchedBookName", books);
		}
			return "searchedbooks";	
		
	}
}
		

