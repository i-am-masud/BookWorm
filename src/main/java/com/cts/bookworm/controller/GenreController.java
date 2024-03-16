package com.cts.bookworm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.bookworm.entities.Books;
import com.cts.bookworm.services.BookService;
@Controller
public class GenreController {
	
	private BookService bookService;
	
	@Autowired
	public GenreController(BookService bookService) {
		this.bookService = bookService;
	}
	
	
	@RequestMapping(value = "/genre/{genreName}", method = RequestMethod.GET)
	public String goToGenreMystery(@PathVariable("genreName") String genreName, Model model) {
		
		List<Books> genreBooks = bookService.getGenreBooks(genreName);
		model.addAttribute("genreName", genreName);
		model.addAttribute("genreBooks", genreBooks);
		
		return "genre";
	}



}
