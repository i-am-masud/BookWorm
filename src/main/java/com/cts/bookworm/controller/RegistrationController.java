package com.cts.bookworm.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.bookworm.dto.UserDto;
import com.cts.bookworm.entities.User;
import com.cts.bookworm.services.UserService;

import jakarta.validation.Valid;

@Controller
public class RegistrationController {

	@Autowired
	private UserService service;

	@Autowired
	private ModelMapper modelMapper;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String goToRegistration(@ModelAttribute("registeruser") UserDto userDto) {
		return "registration";
	}

	@PostMapping("/registration")
	public String letRegistrationDone(@RequestParam("email") String email, @RequestParam("username") String username,
			@Valid @ModelAttribute("registeruser") UserDto userDto, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}
		
//		-------------------------------------------------------------------------------------------------------------------------------
//		To find if the email already exists or not while registering a new user
//		-------------------------------------------------------------------------------------------------------------------------------
		
		User user2 = service.findUserByEmail(email);
		if (user2 != null) {
			if (user2.getEmail().equals(email)) {
				model.put("emailError", "Email already exists");
				return "registration";
			}
		} 
		
//		-------------------------------------------------------------------------------------------------------------------------------
//		To find if the username already exists or not while registering a new user
//		-------------------------------------------------------------------------------------------------------------------------------

		User user3 = service.findUserByUsername(username);
		if (user3 != null) {
			if (user3.getUsername().equals(username)) {
				model.put("usernameError", "Username already exists");
				return "registration";
			}
		}

		User user = modelMapper.map(userDto, User.class);
		service.registerUser(user);

		return "success";

	}
}
