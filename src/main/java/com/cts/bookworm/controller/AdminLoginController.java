package com.cts.bookworm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.bookworm.services.AdminService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminLoginController {
	@RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
	public String goToAdminLogin() {
		return "adminlogin";
	}

//-------------------------------------------------------------------------------------------------------------
//	Admin Login
//-------------------------------------------------------------------------------------------------------------

	private AdminService adminService;

	@Autowired
	public AdminLoginController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}

	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public String goToWelcome(@RequestParam("adminusername") String adminusername,
			@RequestParam("adminpassword") String adminpassword, ModelMap model, HttpSession session) {

		if (adminService.authenticate(adminusername, adminpassword)) {
			session.setAttribute("adminLoggedIn", true);
			session.setAttribute("adminusername", adminusername);
			return "redirect:/admindashboard";
		}
		model.put("Error", "Invalid credentials! Try again");
		return "adminlogin";
	}
	
	

//  ---------------------------------------------------------------------------------------------------------
//	Admin Logout
//	----------------------------------------------------------------------------------------------------
	@GetMapping("/adminlogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}


}
