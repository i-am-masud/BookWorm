package com.cts.bookworm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.bookworm.entities.User;
import com.cts.bookworm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String goToLogin(HttpSession session) {
		User user = (User) session.getAttribute("userLoggedIn");
		if (user != null) {
			return "redirect:/home";
		} else {
			return "login";
		}
	}

//	----------------------------------------------------------------------------------------------------------------------------------------------
//	Logging In
//	----------------------------------------------------------------------------------------------------------------------------------------------
	private UserService userService;

	@Autowired
	public LoginController(UserService userService) {
		this.userService = userService;
	}

	
	
	@PostMapping("/login")
	public String processLogin(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model, HttpSession session) {

		User user = userService.findUserByUsername(username);

		if (user != null) {
			if (user.getPassword().equals(password)) {
				session.setAttribute("userLoggedIn", user);
				return "redirect:/";
			} else {
				model.addAttribute("error", "Invalid Password !  Try again");
				return "login";
			}
		} else {
			model.addAttribute("error", "Invalid Username !  Try again");
			return "login";
		}
	
	}

//	----------------------------------------------------------------------------------------------------------------------------------------------
//	Logging Out
//	----------------------------------------------------------------------------------------------------------------------------------------------

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}

}
