package com.cooksys.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.dto.CredentialsDto;
import com.cooksys.dto.UserInfoDto;
import com.cooksys.exception.FlightBookingException;
import com.cooksys.service.UserService;

@RestController
@RequestMapping("/users/")
@CrossOrigin
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/new/")
	public void postUser(@RequestBody UserInfoDto userInfoDto, HttpServletResponse response) {
		try {
			userService.postUser(userInfoDto);
		} catch (FlightBookingException flt) {
			response.setStatus(FlightBookingException.NOT_ACCEPTABLE);
		}
	}
	
	@PostMapping("/login/")
	public void login(@RequestBody CredentialsDto credentials, HttpServletResponse response) {
		try {
			userService.login(credentials);
		} catch (FlightBookingException flt) {
			response.setStatus(FlightBookingException.NOT_AUTHORIZED);
		}
	}
	
}
