
package com.cooksys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.UserEntity;

public interface UserJpaRepository extends JpaRepository<UserEntity, Integer> {

	UserEntity findByCredentialsUsername(String username);
	
}
