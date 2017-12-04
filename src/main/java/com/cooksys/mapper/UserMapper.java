
package com.cooksys.mapper;

import org.mapstruct.Mapper;
import com.cooksys.dto.UserInfoDto;
import com.cooksys.entity.User;

@Mapper(componentModel="spring", uses={ CredentialsMapper.class })
public interface UserMapper {
	
	User fromUserInfoDto(UserInfoDto userInfoDto);
	
}
