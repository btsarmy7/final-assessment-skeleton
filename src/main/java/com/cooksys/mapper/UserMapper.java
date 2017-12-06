
package com.cooksys.mapper;

import org.mapstruct.Mapper;
import com.cooksys.dto.UserInfoDto;
import com.cooksys.entity.UserEntity;

@Mapper(componentModel="spring", uses={ CredentialsMapper.class })
public interface UserMapper {
	
	UserEntity fromUserInfoDto(UserInfoDto userInfoDto);
	
}
