package com.cooksys.service;

import org.springframework.stereotype.Service;

import com.cooksys.dto.CredentialsDto;
import com.cooksys.dto.UserInfoDto;
import com.cooksys.entity.User;
import com.cooksys.entity.embeddable.Credentials;
import com.cooksys.exception.FlightBookingException;
import com.cooksys.mapper.UserMapper;
import com.cooksys.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	
	private UserMapper userMapper;
	
	public UserService(UserRepository userRepository, UserMapper userMapper) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}
	
	public void login(CredentialsDto credentials) throws FlightBookingException {
		User user = findUser(credentials.getUsername());
		
		if(user == null) {
			throw new FlightBookingException();
		}
		
		if(!user.getCredentials().getPassword().equals(credentials.getPassword())) {
			throw new FlightBookingException();
		}
	}
	
	public User findUser(String username) {
		return userRepository.findByCredentialsUsername(username);
	}

	public void postUser(UserInfoDto userInfoDto) throws FlightBookingException {
		User user = userMapper.fromUserInfoDto(userInfoDto);
		Credentials credentials = user.getCredentials();
		
		if(credentials == null || credentials.getUsername() == null || credentials.getPassword() == null) {
			throw new FlightBookingException();
		}
		
		if(findUser(credentials.getUsername()) == null) {
			userRepository.save(user);
		} else {
			throw new FlightBookingException();
		}
	}
}
