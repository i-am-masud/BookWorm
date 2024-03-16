package com.cts.bookworm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SuccessController {
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public String goToIndex() {
		return "index";
	}
}
