package com.cts.bookworm.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.bookworm.dto.BooksDto;
import com.cts.bookworm.entities.Books;
import com.cts.bookworm.services.BookService;

import jakarta.validation.Valid;
@Controller
public class AddBooksController {
	
	@Autowired
	private BookService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@RequestMapping(value = "/addbooks", method = RequestMethod.GET)
	public String addBooks(@ModelAttribute("bookdetails") Books books) {
		return "addbooks";
	}
	
	@PostMapping("/addbooks")
	public String letAddBooksDone(@Valid @ModelAttribute("bookdetails") BooksDto booksDto, BindingResult result) {
		if (result.hasErrors()) {
			return "addbooks";
		}
		
		Books books = modelMapper.map(booksDto, Books.class);
		service.addBooks(books);
		
		return "bookaddedsuccessfully";
	}
}
