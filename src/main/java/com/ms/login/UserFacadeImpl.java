package com.ms.login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFacadeImpl implements UserFacade {
	
	@Autowired
	private UserDao userDao;

	@Override
	public Optional<User> findUserByName(String username) {
		Optional<User> p = Optional.ofNullable(userDao.findUserByName(username))
        .map(entity -> new UserDto(entity.orElse(new UserEntity())).getUser());
		
		
		return Optional.ofNullable(userDao.findUserByName(username))
	            .map(entity -> new UserDto(entity.orElse(new UserEntity())).getUser());
	}

}
