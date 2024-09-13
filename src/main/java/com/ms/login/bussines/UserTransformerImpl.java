package com.ms.login.bussines;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.login.daos.UserDao;
@Component
public class UserTransformerImpl implements UserTransformer{

	@Autowired
	private UserDao userDao;
	
	@Override
	public Optional<User> getUserByName(final String username) {
		  return userDao.findUserByName(username)
	                .map(entity -> new UserDto(entity).getUser());
	}

}
