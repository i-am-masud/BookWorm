package com.cts.bookworm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cts.bookworm.entities.User;
import com.cts.bookworm.services.UserService;

@Controller
public class ProfileController {
	@Autowired
	public ProfileController(UserService userService) {
		super();
		this.userService = userService;
	}

	private UserService userService;

	@RequestMapping(value = "/profile/{username}", method = RequestMethod.GET)
	public String goToProfile(@PathVariable("username") String username, Model model) {

		User user = userService.findUserByUsername(username);
		model.addAttribute("user", user);
		return "profile";
	}

}
