package com.cooksys.service;

import org.springframework.stereotype.Service;

import com.cooksys.dto.CredentialsDto;
import com.cooksys.dto.UserInfoDto;
import com.cooksys.entity.UserEntity;
import com.cooksys.entity.embeddable.CredentialsEmbeddable;
import com.cooksys.exception.FlightBookingException;
import com.cooksys.mapper.UserMapper;
import com.cooksys.repository.UserJpaRepository;

@Service
public class UserService {

	private UserJpaRepository userJpaRepository;
	
	private UserMapper userMapper;
	
	public UserService(UserJpaRepository userJpaRepository, UserMapper userMapper) {
		this.userJpaRepository = userJpaRepository;
		this.userMapper = userMapper;
	}
	
	public UserEntity pullUser(String username) {
		return userJpaRepository.findByCredentialsUsername(username);
	}
	
	public void login(CredentialsDto credentials) throws FlightBookingException {
		UserEntity user = pullUser(credentials.getUsername());
		
		if(user == null) {
			throw new FlightBookingException();
		}
		
		if(!user.getCredentials().getPassword().equals(credentials.getPassword())) {
			throw new FlightBookingException();
		}
	}

	public void postUser(UserInfoDto userInfoDto) throws FlightBookingException {
		UserEntity user = userMapper.fromUserInfoDto(userInfoDto);
		CredentialsEmbeddable credentials = user.getCredentials();
		
		if(credentials == null || credentials.getUsername() == null || credentials.getPassword() == null) {
			throw new FlightBookingException();
		}
		
		if(pullUser(credentials.getUsername()) == null) {
			userJpaRepository.save(user);
		} else {
			throw new FlightBookingException();
		}
	}
}
