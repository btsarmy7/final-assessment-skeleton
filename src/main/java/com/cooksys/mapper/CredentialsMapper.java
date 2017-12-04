
package com.cooksys.mapper;

import org.mapstruct.Mapper;

import com.cooksys.dto.CredentialsDto;
import com.cooksys.entity.embeddable.Credentials;

@Mapper(componentModel="spring")
public interface CredentialsMapper {

	Credentials fromCredentialsDto(CredentialsDto credentialsDto);
	
	CredentialsDto toCredentialsDto(Credentials credentials);
	
}
