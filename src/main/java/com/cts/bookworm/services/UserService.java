package com.cts.bookworm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.bookworm.entities.User;
import com.cts.bookworm.repos.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
//	..............................................................................................

	public void registerUser(User user) {
		if (user != null) {
			repository.save(user);
		}
	}
//	..............................................................................................

	public User findUserByUsername(String username) {
		 User user = repository.findByUsername(username);
		 if (user != null) {
			 return user;
		 }
		 return null;
	}
	
//	..............................................................................................
	
	public User findUserByEmail(String email) {
		 User user2 = repository.findByEmail(email);
		 if (user2 != null) {
			 return user2;
		 }
		 return null;
	}

}
