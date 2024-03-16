package com.cts.bookworm.services;

import org.springframework.stereotype.Service;

@Service
public class AdminService {

	public boolean authenticate(String adminusername, String adminpassword) {

		boolean isValidUserName = adminusername.equals("BOOKWORMADMIN");
		boolean isValidPassword = adminpassword.equals("BOOKWORMADMIN");

		return isValidUserName && isValidPassword;
	}

}
