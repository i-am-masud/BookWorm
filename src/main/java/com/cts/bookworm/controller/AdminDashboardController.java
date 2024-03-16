package com.cts.bookworm.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.bookworm.dto.BooksDto;
import com.cts.bookworm.entities.Books;
import com.cts.bookworm.services.BookService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminDashboardController {
	@Autowired
	private BookService bookService;

	@Autowired
	private ModelMapper modelMapper;

//	--------------------------------------------------------------------------------------------------------------------
//	Open Admin Dashboard
//	--------------------------------------------------------------------------------------------------------------------

	@RequestMapping(value = "/admindashboard", method = RequestMethod.GET)
	public String goToAdminDashboard(HttpSession session) {
		
		String adminusername = (String) session.getAttribute("adminusername");
		
		if (adminusername != null) {
			return "admindashboard";
		} else {
			return "redirect:/adminlogin";
		}
	}
	
	

//	--------------------------------------------------------------------------------------------------------------------
//	Showing all books in the View Book page
//	--------------------------------------------------------------------------------------------------------------------

	@RequestMapping(value = "/viewbooks", method = RequestMethod.GET)
	public String goToViewBookDetails(Model model, HttpSession session) {
		List<Books> allBookDetails = bookService.findAllBooks();
		model.addAttribute("allBookDetails", allBookDetails);
		
		String adminusername = (String) session.getAttribute("adminusername");

		if (adminusername != null) {
			return "viewbooks";
		} else {
			return "redirect:/adminlogin";
		}
	}
	
	

//	--------------------------------------------------------------------------------------------------------------------
//	Updating books in the View Book page
//	--------------------------------------------------------------------------------------------------------------------
//	Showing the 'Add Book Details' form with original data   |
//	---------------------------------------------------------

	@RequestMapping(value = "/updatebooks/{bookId}", method = RequestMethod.GET)
	public String goToBookUpdateForm(@PathVariable("bookId") int bookId, Model model, HttpSession session) {

		Books book = bookService.getBook(bookId);
		BooksDto bookDto = modelMapper.map(book, BooksDto.class);
		model.addAttribute("command", bookDto);
		
		String adminusername = (String) session.getAttribute("adminusername");

		if (adminusername != null) {
			return "updatebooks";
		} else {
			return "redirect:/adminlogin";
		}

//		return "updatebooks";
	}
	
	

//	----------------------------------------------------------
//	Here we update the Book's deatils and save it to database |
//	----------------------------------------------------------

	@RequestMapping(value = "/updatebooks/bookUpdated", method = RequestMethod.POST)
	public String updateBook(@ModelAttribute("bookDto") BooksDto booksDto, Model model) {

		Books book = modelMapper.map(booksDto, Books.class);
		bookService.UpdateBooks(book);
		return "updatedsuccessfully";
	}
	
	

//	--------------------------------------------------------------------------------------------------------------------
//	Confirming Delete books
//	--------------------------------------------------------------------------------------------------------------------	

	@GetMapping("/confirmdelete/{bookId}")
	public String confirmDeleteOperation(@PathVariable("bookId") int bookId, Model model) {
		model.addAttribute("bookId", bookId);
		return "confirmdelete";
	}
	
	

//	--------------------------------------------------------------------------------------------------------------------
//	Delete books in the View Book page
//	--------------------------------------------------------------------------------------------------------------------	

	@RequestMapping(value = "/deletebooks/{bookId}", method = RequestMethod.GET)
	public String bookDeleted(@PathVariable("bookId") int bookId, Model model) {

		bookService.deleteBook(bookId);

		return "redirect:/viewbooks	";
	}

}
