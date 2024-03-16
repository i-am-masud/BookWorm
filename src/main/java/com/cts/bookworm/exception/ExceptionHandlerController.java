package com.cts.bookworm.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(value= BookNotFoundException.class)
	public String showBookNotFoundError(Model model) {
		model.addAttribute("bookNotFound", true);
		return "searchedbooks";
	}
}
