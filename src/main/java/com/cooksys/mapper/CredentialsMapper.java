
package com.cooksys.mapper;

import org.mapstruct.Mapper;

import com.cooksys.dto.CredentialsDto;
import com.cooksys.entity.embeddable.CredentialsEmbeddable;

@Mapper(componentModel="spring")
public interface CredentialsMapper {

	CredentialsEmbeddable fromCredentialsDto(CredentialsDto credentialsDto);
	
	CredentialsDto toCredentialsDto(CredentialsEmbeddable credentialsEmbeddable);
	
}
