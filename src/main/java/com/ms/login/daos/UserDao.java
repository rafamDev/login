package com.ms.login.daos;

import java.util.Optional;

import com.ms.login.entities.UserEntity;

public interface UserDao {

	Optional<UserEntity> findUserByName(String username);
	
}