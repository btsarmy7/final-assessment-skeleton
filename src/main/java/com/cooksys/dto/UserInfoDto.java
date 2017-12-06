
package com.cooksys.dto;

import com.cooksys.dto.CredentialsDto;


public class UserInfoDto {

	private CredentialsDto credentials;

	public UserInfoDto() { }

	public UserInfoDto(CredentialsDto credentials) {
		this();
		this.credentials = credentials;
	}

	public CredentialsDto getCredentials() {
		return credentials;
	}

	public void setCredentials(CredentialsDto credentials) {
		this.credentials = credentials;
	}

}
