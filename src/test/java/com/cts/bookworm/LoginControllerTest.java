package com.cts.bookworm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import com.cts.bookworm.controller.LoginController;
import com.cts.bookworm.entities.User;
import com.cts.bookworm.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookwormApplicationTests.class)
class LoginControllerTest {
	
	@Mock
	private Model model;
	
	@Mock
	private MockHttpSession session;
	
	@Mock
	private UserService userServiceMock;
	
	@InjectMocks
	private LoginController  loginControllerMock;
	
	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);

	}
	
	@Test
	void contextLoads() {
	}
	
//	-------------------------------------------------------------------------------------------------------------------------------------------------
//	Testing the method for Login
//	-------------------------------------------------------------------------------------------------------------------------------------------------

	@Test
	public void testProcessLoginForPassword() {
		
		String username = "masud";
		String password = "1234";
		
		User mockUser = new User() ;
		mockUser.setPassword("1234");
		
		when(userServiceMock.findUserByUsername(username)).thenReturn(mockUser);
		
		String viewname = loginControllerMock.processLogin(username, password, model, session);

		assertEquals("redirect:/", viewname);
		
		// Verify that userService.findUserByUsername() is called
		verify(userServiceMock).findUserByUsername(username);
		
		
	}
	
//	-------------------------------------------------------------------------------------------------------------------------------------------------
//	Testing the method for Login
//	-------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	@Test
	public void testProcessLoginForInvalidPassword() {
		
		String username = "masud";
		String password = "1234";
		
		User mockUser = new User() ;
		mockUser.setPassword("12345");
		
		when(userServiceMock.findUserByUsername(username)).thenReturn(mockUser);
		
		String viewname = loginControllerMock.processLogin(username, password, model, session);

		assertEquals("login", viewname);
		
		// Verify that userService.findUserByUsername() is called
		verify(userServiceMock).findUserByUsername(username);
		
		
	}

}
